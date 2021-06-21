package servingwebcontent;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "contact")
public class Contact
	{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;

	@OneToMany(targetEntity = Mail.class,mappedBy = "contact")
	private List<Mail> mails = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
				name = "adresses",
				joinColumns = @JoinColumn(name = "contact_id"),
				inverseJoinColumns = @JoinColumn(name = "adresse_id")
				)
	private List<Adresse> adresses = new ArrayList<Adresse>();


	public Contact()
		{
		}




	public void  addAdresse(Adresse adresse)
		{
		adresses.add(adresse);
		}

	public void removeAdresse(Adresse adresse) { adresses.remove(adresse); }

	public Contact(String firstName, String lastName)
		{
		this.firstName = firstName;
		this.lastName = lastName;
		}

	@Override
	public String toString()
		{
		return String.format("Contact[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
		}

	public Long getId()
		{
		return id;
		}

	public String getFirstName()
		{
		return firstName;
		}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

		public String getLastName()
		{
		return lastName;
		}

	public List<Mail> getMails() {
		return mails;
	}

		public List<Adresse> getAdresses()
		{
		return adresses;
		}

	}
