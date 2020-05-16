package ikvych.resume.repository.storage;

import ikvych.resume.entity.Course;
import ikvych.resume.entity.Education;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    Optional<List<Course>> findAllByProfileId(Long profileId);
}
