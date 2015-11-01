package blank.dto;

import blank.mail.smtp.dto.AbstractMailDto;

public class ResetPasswordConfirmMailDto extends AbstractMailDto {

    public ResetPasswordConfirmMailDto(String mailEncode) {
        super(mailEncode);
    }

    public String authKey;
    public String toAddr;

    public String signature
            ="--\r\n"
            +"blankmail\r\n";
}
