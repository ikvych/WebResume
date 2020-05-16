package ikvych.resume.repository.storage;

import ikvych.resume.entity.Education;
import ikvych.resume.entity.Hobby;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EducationRepository extends CrudRepository<Education, Long> {

    Optional<List<Education>> findAllByProfileId(Long profileId);
}
