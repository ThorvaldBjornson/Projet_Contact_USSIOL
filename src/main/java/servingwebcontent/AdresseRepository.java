package servingwebcontent;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AdresseRepository extends CrudRepository<Adresse, Long>
{
	Adresse findById(long id);
	List<Adresse> findByVille(String ville);
	Adresse findByLibelleAndCpAndVille(String libelle, String cp, String ville);
}