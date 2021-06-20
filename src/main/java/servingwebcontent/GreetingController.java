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
	AdresseRepository adresseRepository;
	MailRepository mailRepository;


	@GetMapping("/ajouter_contact")
	public String greeting(Model model)
		{
		model.addAttribute("contact", new Contact());
		return "ajout";
		}

	@PostMapping("/ajouter_contact")
	public String formSubmit(@ModelAttribute Contact contact, Model model)
		{
		model.addAttribute("contact", contact);
		contactRepository.save(contact);
		return "FormResult";
		}

	@GetMapping("/contact/{id}")
	public String testParam(@PathVariable long id, Model model)
		{
		model.addAttribute("contact", contactRepository.findById(id));
		model.addAttribute("adresses", contactRepository.findById(id).getAdresses());
		return "contact";
		}

	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable long id, Model model)
	{
		contactRepository.deleteById(id);
		return "ValidationDelete";
	}
}