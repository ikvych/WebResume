package ikvych.resume.repository;

import ikvych.resume.entity.Practical;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PracticalRepository extends CrudRepository<Practical, Long> {

    Optional<List<Practical>> findAllByProfileId(Long profileId);
}
