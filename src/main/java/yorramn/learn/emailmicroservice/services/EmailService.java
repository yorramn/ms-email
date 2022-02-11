package yorramn.learn.emailmicroservice.services;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import yorramn.learn.emailmicroservice.enums.StatusEmail;
import yorramn.learn.emailmicroservice.models.Email;
import yorramn.learn.emailmicroservice.repositories.EmailRepository;

import java.time.LocalDateTime;

@Service
public class EmailService {
    private final EmailRepository emailRepository;
    private final JavaMailSender javaMailSender;
    public EmailService(EmailRepository emailRepository, JavaMailSender javaMailSender) {
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;

    }

    public Email sendEmail(Email email) {
        email.setSendDateEmail(LocalDateTime.now());
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(email.getMailFrom());
            simpleMailMessage.setTo(email.getMailTo());
            simpleMailMessage.setSubject(email.getSubject());
            simpleMailMessage.setText(email.getText());
            javaMailSender.send(simpleMailMessage);
            email.setStatusEmail(StatusEmail.SENT);
        }catch (MailException mailException){
            email.setStatusEmail(StatusEmail.ERROR);
        }finally {
            return emailRepository.save(email);
        }

    }
}
