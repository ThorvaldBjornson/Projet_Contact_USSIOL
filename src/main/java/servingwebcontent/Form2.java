package servingwebcontent;

public class Form2
	{

	private String libelle;
	private String cp;
	private String ville;


	public Form2()
		{

		}

	public Form2(String libelle, String cp, String ville)
		{
		this.libelle = libelle;
		this.cp = cp;
		this.ville = ville;
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

	}
