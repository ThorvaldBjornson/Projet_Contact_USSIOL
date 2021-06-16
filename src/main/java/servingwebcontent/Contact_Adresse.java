package servingwebcontent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact_Adresse {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long idContact;
    private Long idAdresse;

    protected Contact_Adresse() {}

    public Contact_Adresse(Long idContact, Long idAdresse) {
        this.idContact = idContact;
        this.idAdresse = idAdresse;
    }

    @Override
    public String toString() {
        return String.format(
                "Contact[id=%d, idContact='%s', idAdresse='%s']",
                id, idContact, idAdresse);
    }

    public Long getId() {
        return id;
    }

    public Long getIdContact() {
        return idContact;
    }

    public Long getIdAdresse() {
        return idAdresse;
    }
}
