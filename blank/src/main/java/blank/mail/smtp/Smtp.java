package blank.mail.smtp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import blank.mail.AddressType;
import blank.mail.MailAuthenticator;
import blank.mail.MailException;
import blank.mail.Names;
import blank.mail.util.MailClientUtil;

public class Smtp {

    /** Regexp to find the placeholder in the mail body. */
    private static final Pattern PLACE_HOLDER_PATTERN =
            Pattern.compile(".*(\\$\\{[ ]*data\\.([a-zA-Z]+?)[ ]*\\}).*");

    private Session session;

    private static ResourceBundle bundle;

    public String getMailEncode() {
        return bundle.getString("mail.send.encode");
    }

    /**
     * Load the configurations and create the JavaMail Session.
     *
     * @param bundleBaseName Bundle base name to select witch properties to read.
     */
    public Smtp(String bundleBaseName) {
        // Get the ResourceBundle object to read.
        bundle = ResourceBundle.getBundle(bundleBaseName);

        // Load the SMTP configurations.
        final Properties props = MailClientUtil.loadPropertiesByPrefix(Names.PROP_KEY_PREFIX_SMTP, bundle);
        session = Session.getInstance(
                props, new MailAuthenticator(
                        bundle.getString(Names.PROP_KEY_MAIL_ACCOUNT_ID),
                        bundle.getString(Names.PROP_KEY_MAIL_ACCOUNT_PASSWORD)
                )
        );
    }

    /**
     * メールを送信する.<br>
     *
     * @param dto メールDTO
     * @param mailName メール名
     * @throws MailException メール例外
     */
    public void sendMail(Object dto, String mailName) throws MailException {
        Class<?> dtoClass = dto.getClass();

        session.setDebug(true);

        final MimeMessage message = new MimeMessage(session);

        // メールヘッダの設定
        setHeader(message);

        // fromアドレスの設定
        setFrom(dtoClass, dto, mailName, message);

        // Recipientアドレスの設定
        setRecipient(AddressType.TO, dtoClass, dto, mailName, message);
        setRecipient(AddressType.CC, dtoClass, dto, mailName, message);
        setRecipient(AddressType.BCC, dtoClass, dto, mailName, message);

        // メールタイトルの設定
        setSubject(dtoClass, dto, message);

        // メール本文＆添付ファイルの設定
        setMailBody(dtoClass, dto, mailName, message);

        // メール属性の設定
        setMailAttributes(message);

        try {
            Transport.send(message);

        } catch (AuthenticationFailedException e) {
            // 認証失敗は ここに入ります。
            System.out.println("指定のユーザ名・パスワードでの認証に失敗しました。"
                + e.toString());

        } catch (MessagingException e) {
            // smtpサーバへの接続失敗は ここに入ります。
            System.out.println("指定のsmtpサーバへの接続に失敗しました。" + e.toString());
            e.printStackTrace();

        }
    }

    private void setHeader(MimeMessage message) throws MailException {
        try {
            message.setHeader("Content-Transfer-Encoding", "7bit");
            message.addHeader("X-Mailer", "blancoMail 0.1");

        } catch (MessagingException e) {
            throw new MailException("メールヘッダ設定中に例外発生.", e);
        }

    }

    private void setFrom(Class<?> dtoClass, Object dto, String mailName, Message message) throws MailException {
        try {
            String propFrom = bundle.getString("mail.send."+ mailName + ".from");
            if(propFrom != null) {
                // プロパティファイルに from アドレスが設定されていれば、DTOに詰める(上書きする)
                try {
                    dtoClass.getMethod("addAddress", AddressType.class, String.class, String.class)
                        .invoke(dto,
                                AddressType.FROM,
                                propFrom.split(",")[0],
                                propFrom.split(",")[1]
                    );
                } catch (InvocationTargetException e) {
                    throw new MailException("プロパティファイルに設定された From アドレス設定中に例外発生.", e);

                } catch (NoSuchMethodException e) {
                    throw new MailException("プロパティファイルに設定された From アドレス設定中に例外発生.", e);
                }
            }

            InternetAddress from = (InternetAddress)dtoClass.getField("from").get(dto);
            if(from != null) {
                // Fromアドレスが設定されていれば message に詰める.
                message.setFrom(from);

            } else {
                throw new MailException("Fromアドレスが設定されていません(必須).", null);
            }

        } catch (IllegalArgumentException e) {
            throw new MailException("Fromアドレス設定中に例外発生.", e);

        } catch (SecurityException e) {
            throw new MailException("Fromアドレス設定中に例外発生.", e);

        } catch (IllegalAccessException e) {
            throw new MailException("Fromアドレス設定中に例外発生.", e);

        } catch (NoSuchFieldException e) {
            throw new MailException("Fromアドレス設定中に例外発生.", e);

        } catch (MessagingException e) {
            throw new MailException("Fromアドレス設定中に例外発生.", e);

        }
    }

    private void setRecipient(AddressType addressType, Class<?> dtoClass, Object dto, String mailName,
            Message message) throws MailException {

        try {
            String fieldName = "";
            RecipientType recipientType = null;

            switch (addressType) {
            case TO:
                fieldName = "to";
                recipientType = Message.RecipientType.TO;
                break;

            case CC: fieldName = "cc";
                fieldName = "cc";
                recipientType = Message.RecipientType.CC;
                break;

            case BCC: fieldName = "bcc";
                fieldName = "bcc";
                recipientType = Message.RecipientType.BCC;
                break;

            default:
                throw new MailException("アドレス設定中に不正なAddressTypeが指定されました.", null);
            }

            // dtoのアドレスを設定する.
            Set<String> keys = MailClientUtil.getPropertyKeySetByPrefix(
                    "mail.send."+ mailName + "." + fieldName, bundle);
            for(String key: keys) {
                dtoClass.getMethod("addAddress", AddressType.class, String.class, String.class)
                .invoke(dto, addressType,
                        bundle.getString(key).split(",")[0],
                        bundle.getString(key).split(",")[1]
                        );
            }

            @SuppressWarnings("unchecked")
            List<InternetAddress> addressList = (ArrayList<InternetAddress>)dtoClass.getField(fieldName).get(dto);
            for(InternetAddress address : addressList) {
                message.addRecipient(recipientType, address);
            }

        } catch (IllegalArgumentException e) {
            throw new MailException("アドレス設定中に例外発生. ("+ addressType.name() +")", e);

        } catch (SecurityException e) {
            throw new MailException("アドレス設定中に例外発生. ("+ addressType.name() +")", e);

        } catch (IllegalAccessException e) {
            throw new MailException("アドレス設定中に例外発生. ("+ addressType.name() +")", e);

        } catch (NoSuchFieldException e) {
            throw new MailException("アドレス設定中に例外発生. ("+ addressType.name() +")", e);

        } catch (MessagingException e) {
            throw new MailException("アドレス設定中に例外発生. ("+ addressType.name() +")", e);

        } catch (InvocationTargetException e) {
            throw new MailException("アドレス設定中に例外発生. ("+ addressType.name() +")", e);

        } catch (NoSuchMethodException e) {
            throw new MailException("アドレス設定中に例外発生. ("+ addressType.name() +")", e);
        }
    }

    private void setSubject(Class<?> dtoClass, Object dto, MimeMessage message) throws MailException {
        try {
            message.setSubject(
                    (String)dtoClass.getField("subject").get(dto),
                    getMailEncode()
            );

        } catch (IllegalArgumentException e) {
            throw new MailException("Subject設定中に例外発生.", e);

        } catch (SecurityException e) {
            throw new MailException("Subject設定中に例外発生.", e);

        } catch (IllegalAccessException e) {
            throw new MailException("Subject設定中に例外発生.", e);

        } catch (NoSuchFieldException e) {
            throw new MailException("Subject設定中に例外発生.", e);

        } catch (MessagingException e) {
            throw new MailException("Subject設定中に例外発生.", e);
        }
    }

    private String getBody(Object dto, String templateFilePath, String templateCharset) throws MailException {

        // Get the class object of the given dto.
        Class<?> dtoClass = dto.getClass();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(new File(templateFilePath)), Charset.forName(templateCharset)));

        } catch (FileNotFoundException e) {
            throw new MailException("Exception occured while reading the template file.", e);
        }

        String line;
        StringBuffer body = new StringBuffer();

        try {
            while((line = reader.readLine()) != null) {
                // プレースホルダを順に置換.
                while(true) {
                    Matcher matcher = PLACE_HOLDER_PATTERN.matcher(line);
                    if(matcher.matches()) {
                        String replacement = null;
                        try {
                            replacement = (String)dtoClass.getField(matcher.group(2)).get(dto);

                        } catch (IllegalArgumentException e) {
                            throw new MailException(
                                    "Exception occured while replacing the placeholder. "
                                    + "{key="+ matcher.group(2) + "}", e);

                        } catch (SecurityException e) {
                            throw new MailException(
                                    "Exception occured while replacing the placeholder. "
                                    + "{key="+ matcher.group(2) + "}", e);

                        } catch (IllegalAccessException e) {
                            throw new MailException(
                                    "Exception occured while replacing the placeholder. "
                                    + "{key="+ matcher.group(2) + "}", e);

                        } catch (NoSuchFieldException e) {
                            throw new MailException(
                                    "Exception occured while replacing the placeholder. "
                                    + "{key="+ matcher.group(2) + "}", e);
                        }
                        line = line.replace(matcher.group(1), replacement);

                    } else {
                        break;
                    }
                }
                body.append(line).append("\n");
            }

        } catch (IOException e) {
            throw new MailException("IOException occured while reading the template file. "
                    + "{template="+ templateFilePath +"}", e);

        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return body.toString();
    }

    private void setMailBody(Class<?> dtoClass, Object dto, String mailName, MimeMessage message)
            throws MailException {
        try {
            // メール本文を作成する.
            MimeBodyPart bodyPart = new MimeBodyPart();
            bodyPart.setText(getBody(dto,
                    bundle.getString("mail.send."+ mailName + ".template.file"),
                    bundle.getString("mail.send."+ mailName + ".template.charset")
            ), getMailEncode());

            // メール本文をMultipartに詰める.
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(bodyPart);

            // 添付ファイルをMultipartに詰める.
            @SuppressWarnings("unchecked")
            List<File> attachedFiles = (List<File>)dtoClass.getField("attachedFiles").get(dto);
            for(File file : attachedFiles) {
                MimeBodyPart atachmentPart = new MimeBodyPart();
                FileDataSource dataSource = new FileDataSource(file);
                atachmentPart.setDataHandler(new DataHandler(dataSource));
                atachmentPart.setFileName(MimeUtility.encodeWord(dataSource.getName()));

                multipart.addBodyPart(atachmentPart);
            }
            message.setContent(multipart);

        } catch (IllegalArgumentException e) {
            throw new MailException("メール本文生成中に例外発生.", e);

        } catch (SecurityException e) {
            throw new MailException("メール本文生成中に例外発生.", e);

        } catch (IOException e) {
            throw new MailException("メール本文生成中に例外発生.", e);

        } catch (IllegalAccessException e) {
            throw new MailException("メール本文生成中に例外発生.", e);

        } catch (NoSuchFieldException e) {
            throw new MailException("メール本文生成中に例外発生.", e);

        } catch (MessagingException e) {
            throw new MailException("メール本文生成中に例外発生.", e);

        } catch (MailException e) {
            throw new MailException("メール本文生成中に例外発生.", e);
        }
    }

    private void setMailAttributes(MimeMessage message) throws MailException {
        try {
            message.setSentDate(new Date());

        } catch (MessagingException e) {
            throw new MailException("メール属性追加中に例外発生.", e);
        }

    }
}
