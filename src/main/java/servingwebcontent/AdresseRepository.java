package servingwebcontent;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AdresseRepository extends CrudRepository<Adresse, Long>
	{
	Adresse findByAdresse(String ligne, String CP, String ville);
	Optional<Adresse> findById(Long id);
	}