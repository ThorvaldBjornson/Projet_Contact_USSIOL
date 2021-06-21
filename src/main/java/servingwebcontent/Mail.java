package servingwebcontent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mail")
public class Mail {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String mail;

    @ManyToOne
    @JoinColumn(name="contact", nullable = false)
    private Contact contact;

    public Mail()
        {
        }

    public Mail(String mail, Contact contact)
    {
        this.mail = mail;
        this.contact = contact;
    }

    @Override
    public String toString() {
        return String.format(
                "Mail[id=%d, mail='%s']",
                id, mail);
    }

    public Long getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
