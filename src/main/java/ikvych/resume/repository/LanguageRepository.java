package ikvych.resume.repository;

import ikvych.resume.entity.Language;
import ikvych.resume.entity.Practical;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

    Optional<List<Language>> findAllByProfileId(Long profileId);
}
