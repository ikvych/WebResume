package ikvych.resume.repository.storage;

import ikvych.resume.entity.Practical;
import ikvych.resume.entity.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {

    Optional<List<Skill>> findAllByProfileId(Long profileId);
}
