package servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GreetingController
{

	@GetMapping("/index")
	public String index(Model model) {
	List<Contact> contact = new ArrayList<Contact>();
	for(Contact cont : contactRepository.findAll()){
	contact.add(cont);
	}
	model.addAttribute("contact", contact);
	return "lecture";
	}

	@Autowired
	ContactRepository contactRepository;
	@Autowired
	AdresseRepository adresseRepository;
	MailRepository mailRepository;


	@GetMapping("/ajouter_contact")
	public String greeting(Model model)
		{
		model.addAttribute("form", new Form());
		return "ajout";
		}

	@PostMapping("/ajouter_contact")
	public String formSubmit(@ModelAttribute Form form, Model model)
		{
		Adresse adresse = new Adresse(form.getLibelle(), form.getCp(), form.getVille());
		adresseRepository.save(adresse);

		Contact contact = new Contact(form.getPrenom(), form.getNom());
		contact.addAdresse(adresse);

		contactRepository.save(contact);

		//Mail mail = new Mail(form.getMail());

		return "redirect:/index";
		}

	@GetMapping("/contact/{id}")
	public String testParam(@PathVariable long id, Model model)
		{
		Contact contact = contactRepository.findById(id);
		model.addAttribute("contact", contact);
		model.addAttribute("adresses", contactRepository.findById(id).getAdresses());
		try
		{
			model.addAttribute("mails", contact.getMails());
		}catch (Exception e)
		{

		}
		//model.addAttribute("mails", mailRepository.findByContact(contact));
		return "contact";
		}

	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable long id, Model model)
	{
		contactRepository.deleteById(id);
		return "ValidationDelete";
	}
}