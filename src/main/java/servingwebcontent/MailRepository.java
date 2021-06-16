package servingwebcontent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MailRepository extends CrudRepository<Mail, Long>
{
    Mail findByMail(String mail);
    List<Mail> findByIdContact(Long idContact);
    Mail findById(long id);
}
