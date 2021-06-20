package servingwebcontent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ContactApplication
    {



    private static final Logger log = LoggerFactory.getLogger(ContactApplication.class);

    public static void main(String[] args)
        {
        SpringApplication.run(ContactApplication.class);
        }


    @Bean
    public CommandLineRunner demo(ContactRepository contactRepository, AdresseRepository adresseRepository, MailRepository mailRepository) {
        return (args) -> {

        Mail mail1 = new Mail("bonjour@bonjour.com", contactRepository.findById(5L));
        Mail mail2 = new Mail("aaa@aaaa.com", contactRepository.findById(5L));

        mailRepository.save(mail1);
        mailRepository.save(mail2);

        Adresse adresse1 = new Adresse("2 place d'Erlon", "51100", "Reims");
        Adresse adresse2 = new Adresse("1 rue de la fontaine", "51100", "Reims");

        adresseRepository.save(adresse1);
        adresseRepository.save(adresse2);

        Contact c1 = new Contact("Jack", "Bauer");
        Contact c2 = new Contact("Kim", "Bauer");
        Contact c3 = new Contact("David", "Palmer");
        Contact c4 = new Contact("Michelle", "Dessler");

        c1.addAdresse(adresse1);
        c1.addAdresse(adresse2);
        c2.addAdresse(adresse2);

       // c1.addMail(mail1);
       // c1.addMail(mail2);

        contactRepository.save(c1);
        contactRepository.save(c2);
        contactRepository.save(c3);
        contactRepository.save(c4);



        log.info("------------- Contacts des adresses ------------");
        log.info(".................................................");
        for (Contact contact : contactRepository.findAll())
            {
            log.info("-------------------------------------------------");
            log.info(contact.toString());
            List<Adresse> l1 = contact.getAdresses();

            l1.forEach(adresse -> log.info(adresse.toString()));

            }

       /* log.info("------------- Contacts des mails ------------");
        log.info(".................................................");
        for (Contact contact : contactRepository.findAll())
            {
            log.info("-------------------------------------------------");
            log.info(contact.toString());
            List<Mail> l2 = contact.getMails();
            l2.forEach(mail -> log.info(mail.toString()));
            }*/
        log.info("");
        /*log.info("------------- Adresses des contacts ------------");
        log.info(".................................................");
        for (Contact contact : contactRepository.findAll())
            {
            log.info("-------------------------------------------------");
            log.info(contact.getFirstName());
            log.info(contact.getLastName());
            List<Adresse> l = contact.getAdresses();
            l.forEach(adresse -> log.info(adresse.toString()));
            }
        log.info("");*/
/*
        log.info("Adresses found with findAll():");
        log.info("-------------------------------");
        for (Adresse adresse: adresseRepository.findAll()) {
        log.info(adresse.toString());
        }
        log.info("");*/

        // save a few contacts
   /*         contactRepository.save(new Contact("Jack", "Bauer"));
            contactRepository.save(new Contact("Chloe", "O'Brian"));
            contactRepository.save(new Contact("Kim", "Bauer"));
            contactRepository.save(new Contact("David", "Palmer"));
            contactRepository.save(new Contact("Michelle", "Dessler"));

            // fetch all contacts
            log.info("Contacts found with findAll():");
            log.info("-------------------------------");
            for (Contact contact : contactRepository.findAll()) {
                log.info(contact.toString());
            }
            log.info("");

            // fetch an individual contact by ID
            Contact contact = contactRepository.findById(1L);
            log.info("Contact found with findById(1L):");
            log.info("--------------------------------");
            log.info(contact.toString());
            log.info("");

            // fetch contacts by last name
            log.info("Contact found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            contactRepository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Contact bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");


            // fetch all contacts
            log.info("Adresses found with findAll():");
            log.info("-------------------------------");
            for (Adresse adresse : adresseRepository.findAll()) {
                log.info(adresse.toString());
            }
            log.info("");

            // fetch an individual adresses
            log.info("Adresses found with findByVille(\"Reims\"):");
            log.info("--------------------------------");
            for (Adresse adresse : adresseRepository.findByVille("Reims")) {
                log.info(adresse.toString());
            }
            log.info("");

            // save a few mails
            mailRepository.save(new Mail("mail@gmail.com", 1L));
            mailRepository.save(new Mail("test@outlook.com", 2L));

            // fetch all mails
            log.info("Mails found with findAll():");
            log.info("-------------------------------");
            for (Mail mail : mailRepository.findAll()) {
                log.info(mail.toString());
            }
            log.info("");

            // fetch few mail using contact id
            log.info("Mails found with findByIdContact(1L):");
            log.info("-------------------------------");
            for (Mail mail : mailRepository.findByIdContact(1L)) {
                log.info(mail.toString());
            }
            log.info("");

            // save a few mails
            contact_adresse_repository.save(new Contact_Adresse(1L, 1L));
            contact_adresse_repository.save(new Contact_Adresse(1L, 2L));

            // fetch all mails
            log.info("contact_adresse found with findAll():");
            log.info("-------------------------------");
            for (Contact_Adresse contact_adresse : contact_adresse_repository.findAll()) {
                log.info(contact_adresse.toString());
            }
            log.info("");

            // fetch an individual contact_adresse
            log.info("contact_adresse found with findById(10L):");
            log.info("--------------------------------");
            Contact_Adresse Contact_Adresse_Individual = contact_adresse_repository.findById(10L);
            log.info(Contact_Adresse_Individual.toString());
            log.info("");

            // fetch few Contact_Adresse using contact id
            log.info("Contact_Adresse found with findByIdContact(1L):");
            log.info("-------------------------------");
            for (Contact_Adresse contact_adresse : contact_adresse_repository.findByIdContact(1L)) {
                log.info(contact_adresse.toString());
            }
            log.info("");

            // fetch few Contact_Adresse using adresse id
            log.info("Contact_Adresse found with findByIdAdresse(1L):");
            log.info("-------------------------------");
            for (Contact_Adresse contact_adresse : contact_adresse_repository.findByIdAdresse(1L)) {
                log.info(contact_adresse.toString());
            }
            log.info("");*/
        };
    }

}
