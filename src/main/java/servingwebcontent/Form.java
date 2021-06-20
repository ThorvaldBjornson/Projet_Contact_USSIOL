package servingwebcontent;

public class Form
	{
	private String nom;
	private String prenom;
	private String libelle;
	private String cp;
	private String ville;
	private String mail;

	public Form()
		{

		}

	public Form(String nom, String prenom, String libelle, String cp, String ville, String mail)
		{
		this.nom = nom;
		this.prenom = prenom;
		this.libelle = libelle;
		this.cp = cp;
		this.ville = ville;
		this.mail = mail;
		}

	public String getNom()
		{
		return nom;
		}

	public void setNom(String nom)
		{
		this.nom = nom;
		}

	public String getPrenom()
		{
		return prenom;
		}

	public void setPrenom(String prenom)
		{
		this.prenom = prenom;
		}

	public String getLibelle()
		{
		return libelle;
		}

	public void setLibelle(String libelle)
		{
		this.libelle = libelle;
		}

	public String getCp()
		{
		return cp;
		}

	public void setCp(String cp)
		{
		this.cp = cp;
		}

	public String getVille()
		{
		return ville;
		}

	public void setVille(String ville)
		{
		this.ville = ville;
		}

	public String getMail()
		{
		return mail;
		}

	public void setMail(String mail)
		{
		this.mail = mail;
		}

	}
