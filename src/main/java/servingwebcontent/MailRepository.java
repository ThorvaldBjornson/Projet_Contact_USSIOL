package servingwebcontent;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface MailRepository extends CrudRepository<Mail, Long>
	{
	Mail findByMail(String Mail);
	Optional<Mail> findById(Long Id);
	}