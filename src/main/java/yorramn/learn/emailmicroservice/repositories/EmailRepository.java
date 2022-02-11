package yorramn.learn.emailmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yorramn.learn.emailmicroservice.models.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

}
