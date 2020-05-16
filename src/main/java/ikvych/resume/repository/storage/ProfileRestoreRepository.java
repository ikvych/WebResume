package ikvych.resume.repository.storage;

import ikvych.resume.entity.ProfileRestore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRestoreRepository extends CrudRepository<ProfileRestore, Long> {
}
