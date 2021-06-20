package servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class APIController
	{
	@Autowired
	ContactRepository contactRepository;

	@Autowired
	MailRepository mailRepository;

	@GetMapping("/api/contacts")
	List<Contact> all()
		{
		return (List<Contact>) contactRepository.findAll();
		}

	@GetMapping("/api/contact/{id}")
	Contact contact(@PathVariable long id)
		{
		return (Contact) contactRepository.findById(id);
		}

	@GetMapping("/api/delete_contact/{id}")
	String delcontact(@PathVariable long id)
		{
		mailRepository.deleteAll(mailRepository.findByContact(contactRepository.findById(id)));
		contactRepository.deleteById(id);
		return "Delete successful";
		}
	}
