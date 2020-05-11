package ikvych.resume.service;

import ikvych.resume.entity.Profile;

public interface FindProfileService {

    Profile findProfileById (Long profileId);

    Profile findProfileByUid (String uid);
}
