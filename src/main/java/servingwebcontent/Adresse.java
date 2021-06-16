package servingwebcontent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String cp;
    private String ville;

    protected Adresse() {}

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

    public String getCP() {
        return cp;
    }

    public String getVille(){ return ville; }

}
