package servingwebcontent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MailRepository extends CrudRepository<Mail, Long>
{

    Mail findById(long id);
    List<Mail> findByContact(Contact contact);
    Mail findByMail(String mail);
}
