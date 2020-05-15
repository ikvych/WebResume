package ikvych.resume.repository;

import ikvych.resume.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {

    Optional<Profile> findByUid(String uid);

    Profile findByUidOrEmailOrPhone(String uid, String email, String phone);
}
