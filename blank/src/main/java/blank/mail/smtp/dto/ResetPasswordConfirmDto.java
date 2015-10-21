package blank.mail.smtp.dto;

public class ResetPasswordConfirmDto extends AbstractMailDto {

    public ResetPasswordConfirmDto(String mailEncode) {
        super(mailEncode);
    }

    public String authKey;
    public String toAddr;
}
