package ikvych.resume.repository.storage;

import ikvych.resume.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByEmail(String email);

    Optional<Profile> findById(Long id);

    Optional<Profile> findByUid(String uid);

    Profile findByUidOrEmailOrPhone(String uid, String email, String phone);

    Page<Profile> findAll(Pageable pageable);
}
