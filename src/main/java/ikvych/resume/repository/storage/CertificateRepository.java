package ikvych.resume.repository.storage;

import ikvych.resume.entity.Certificate;
import ikvych.resume.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CertificateRepository extends CrudRepository<Certificate, Long> {

    Optional<List<Certificate>> findAllByProfileId(Long profileId);
}
