package ikvych.resume.repository;

import ikvych.resume.entity.Hobby;
import ikvych.resume.entity.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HobbyRepository extends CrudRepository<Hobby, Long> {

    Optional<List<Hobby>> findAllByProfileId(Long profileId);
}
