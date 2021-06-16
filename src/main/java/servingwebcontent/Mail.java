package servingwebcontent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mail {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String mail;
    private Long idContact;

    protected Mail() {}

    public Mail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return String.format(
                "Contact[id=%d, mail='%s', idContact='%s']",
                id, mail);
    }

    public Long getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public Long getIdContact() { return idContact; }
}
