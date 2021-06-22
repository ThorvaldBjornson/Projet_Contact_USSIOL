package servingwebcontent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class APIController
	{
	@Autowired
	ContactRepository contactRepository;

	@Autowired
	MailRepository mailRepository;

	@Autowired
	AdresseRepository adresseRepository;

	@GetMapping(path = "/api/contacts", produces = MediaType.APPLICATION_XML_VALUE)
	List<Contact> all()
		{
		return (List<Contact>) contactRepository.findAll();
		}

	@GetMapping(path = "/api/contact/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	Contact contact(@PathVariable long id)
		{
		return (Contact) contactRepository.findById(id);
		}

	@GetMapping(path = "/api/delete_contact/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	String delcontact(@PathVariable long id)
		{
		mailRepository.deleteAll(mailRepository.findByContact(contactRepository.findById(id)));
		contactRepository.deleteById(id);
		return "<message>Delete successful</message>";
		}

	@PostMapping(path = "/api/ajouter_contact/", consumes = MediaType.APPLICATION_XML_VALUE)
	String AddContact(@RequestBody ContactDetailsRequestModel contactDetails) throws Exception
		{
			Adresse adresse = new Adresse(contactDetails.getLibelle(), contactDetails.getCp(), contactDetails.getVille());
			adresseRepository.save(adresse);

			Contact contact = new Contact(contactDetails.getFirstName(), contactDetails.getLastName());
			contact.addAdresse(adresse);
			contactRepository.save(contact);

			Mail mail = new Mail(contactDetails.getMail(), contact);

			mailRepository.save(mail);
			return "<message>add successful</message>";
		}
	}
