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

   /* @ManyToOne
    @JoinColumn( name="contact_id" )
    private Contact contact;


    public Contact getContact() {
    return contact;
    }

    public void setContact(Contact contact) {
    this.contact = contact;
    }
*/

    public Mail()
        {
        }

    public Mail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return String.format(
                "Contact[id=%d, mail='%s']",
                id, mail);
    }

    public Long getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

}
