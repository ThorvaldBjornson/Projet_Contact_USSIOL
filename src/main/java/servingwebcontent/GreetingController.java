package servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	@Autowired
	MailRepository mailRepository;


	@GetMapping("/ajouter_contact")
	public String pageAddContact(Model model)
		{
		model.addAttribute("form", new Form());
		return "ajout";
		}

	@PostMapping("/ajouter_contact")
	public String addContact(@ModelAttribute Form form, Model model)
		{
		Adresse adresse = new Adresse(form.getLibelle(), form.getCp(), form.getVille());
		adresseRepository.save(adresse);

		Contact contact = new Contact(form.getPrenom(), form.getNom());
		contact.addAdresse(adresse);
		contactRepository.save(contact);

		Mail mail = new Mail(form.getMail(), contact);

		mailRepository.save(mail);
		return "redirect:/index";
		}

	@GetMapping("/ajouter_mail/{id}")
	public String addMailGet(@PathVariable long id, Model model)
		{
		model.addAttribute("id", id);
		model.addAttribute("mail", new String());
		return "ajout_mail";
		}

	@PostMapping("/ajouter_mail/{id}")
	public String addMailPost(@PathVariable long id, @ModelAttribute String mail, Model model)
		{
		String redirection = new String();
		if(mailRepository.findByMail(mail) == null)
			{
			Mail mail1 = new Mail(mail, contactRepository.findById(id));
			mailRepository.save(mail1);
			redirection = "redirect:/index";
			}
		else
			{
			redirection = "redirect:/erreur_ajout";
			}
		return redirection;
		}

	@GetMapping("/erreur_ajout")
	public String erreur_ajout(Model model)
		{
		return "erreur_ajout";
		}

	@GetMapping("/ajouter_adresse/{id}")
	public String addAdressGet(@PathVariable long id, Model model)
		{
		model.addAttribute("id", id);
		model.addAttribute("form2", new Form2());
		return "ajout_adresse";
		}

	@PostMapping("/ajouter_adresse/{id}")
	public String addAdressPost(@PathVariable long id, @ModelAttribute Form2 form, Model model)
		{
		Adresse adr = adresseRepository.findByLibelleAndCpAndVille(form.getLibelle(), form.getCp(), form.getVille());
		Contact c = contactRepository.findById(id);
		if(adr == null)
			{
			adr = new Adresse(form.getLibelle(), form.getCp(), form.getVille());
			adresseRepository.save(adr);
			}
		c.addAdresse(adr);
		contactRepository.save(c);
		return "redirect:/index";
		}

	@GetMapping("/contact/{id}")
	public String getContact(@PathVariable long id, Model model)
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