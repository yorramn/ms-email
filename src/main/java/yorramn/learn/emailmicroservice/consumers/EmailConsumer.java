package yorramn.learn.emailmicroservice.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import yorramn.learn.emailmicroservice.models.Email;
import yorramn.learn.emailmicroservice.requests.EmailRequest;
import yorramn.learn.emailmicroservice.services.EmailService;

@Component
public class EmailConsumer {
    private final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
    public void listen(@Payload EmailRequest emailRequest){
        Email email = new Email();
        BeanUtils.copyProperties(emailRequest, email);
        emailService.sendEmail(email);
        System.out.println("Email status: "+ email.getStatusEmail().toString());
    }
}
