package ikvych.resume.service;

import ikvych.resume.entity.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindProfileService {

    Profile findProfileByEmail(String email);

    Profile findProfileById(Long profileId);

    Profile findProfileByUid(String uid);

    Page<Profile> findAll(Pageable pageable);

    Iterable<Profile> findAllForIndexing();

    Page<Profile> findAllBySearchQuery(String query, Pageable pageable);

}
