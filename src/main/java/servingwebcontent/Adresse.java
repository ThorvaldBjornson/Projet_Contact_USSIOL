package servingwebcontent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Adresse {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String cp;
    private String ville;

    @ManyToMany
    private List<Contact> contacts = new ArrayList<Contact>();

    public void  addAdresse(Contact contact)
        {
        contacts.add(contact);
        }


    public Adresse() {}

    public Adresse(String libelle, String cp, String ville) {
        this.libelle = libelle;
        this.cp = cp;
        this.ville = ville;
    }

    @Override
    public String toString() {
        return String.format(
                "Adresse[id=%d, libelle='%s', cp='%s', ville='%s']",
                id, libelle, cp, ville);
    }

    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getCp() {
        return cp;
    }

    public String getVille(){ return ville; }

    public List<Contact> getContacts(){ return contacts; }


}
