package yorramn.learn.emailmicroservice.requests;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class EmailRequest {
    @NotBlank
    private String owner;
    @NotBlank
    @Email
    private String mailFrom;
    @NotBlank
    @Email
    private String mailTo;
    @NotBlank
    private String subject;
    @NotBlank
    private String text;
}
