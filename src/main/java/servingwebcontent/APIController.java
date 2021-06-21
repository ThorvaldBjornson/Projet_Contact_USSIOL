package servingwebcontent;

import org.springframework.beans.BeanUtils;
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
		return "Delete successful";
		}

	@PostMapping(path = "/api/ajouter_contact/", consumes = MediaType.APPLICATION_XML_VALUE)
	String AddContact(@RequestBody ContactDetailsRequestModel contactDetails) throws Exception
		{
			Contact contact = new Contact();
			contact.setFirstName(contactDetails.getFirstName());
			contact.setLastName(contactDetails.getLastName());
			contactRepository.save(contact);
			return "add successful";
		}
	}
