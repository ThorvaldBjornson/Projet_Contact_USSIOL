package servingwebcontent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactApplication {

    private static final Logger log = LoggerFactory.getLogger(ContactApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ContactApplication.class);
    }

    @Bean
    public CommandLineRunner demo(ContactRepository contactRepository, AdresseRepository adresseRepository, MailRepository mailRepository, Contact_Adresse_Repository contact_adresse_repository) {
        return (args) -> {
            // save a few contacts
            contactRepository.save(new Contact("Jack", "Bauer"));
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

            // save a few Adresses
            adresseRepository.save(new Adresse("36 rue de la paix", "08000", "Charleville-Mézières"));
            adresseRepository.save(new Adresse("92 rue du pont", "51100", "Reims"));

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

            // fetch an individual mail
            log.info("Mail found with findByMail(test@outlook.com):");
            log.info("--------------------------------");
            Mail mailIndividual = mailRepository.findByMail("test@outlook.com");
            log.info(mailIndividual.toString());
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
            log.info("");
        };
    }

}