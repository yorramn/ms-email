package yorramn.learn.emailmicroservice.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yorramn.learn.emailmicroservice.models.Email;
import yorramn.learn.emailmicroservice.requests.EmailRequest;
import yorramn.learn.emailmicroservice.services.EmailService;

import javax.validation.Valid;

@RestController
public class EmailController {
    final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<Object> sendingEmail(@RequestBody @Valid EmailRequest emailRequest){
        Email email = new Email();
        BeanUtils.copyProperties(emailRequest, email);
        emailService.sendEmail(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
}
