package yorramn.learn.emailmicroservice.models;

import lombok.Data;
import yorramn.learn.emailmicroservice.enums.StatusEmail;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table
public class Email implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String owner;
    private String mailFrom;
    private String mailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;

}
