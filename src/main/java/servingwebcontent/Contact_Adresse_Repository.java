package servingwebcontent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface Contact_Adresse_Repository extends CrudRepository<Contact_Adresse, Long>
{
    List<Contact_Adresse> findByIdContact(Long idContact);
    List<Contact_Adresse> findByIdAdresse(Long idAdresse);
    Contact_Adresse findById(long id);
}
