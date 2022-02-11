package yorramn.learn.emailmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yorramn.learn.emailmicroservice.models.Email;

import java.util.UUID;

@Repository
public interface EmailRepository extends JpaRepository<Email, UUID> {

}
