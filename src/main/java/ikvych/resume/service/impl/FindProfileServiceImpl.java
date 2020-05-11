package ikvych.resume.service.impl;

import ikvych.resume.entity.Profile;
import ikvych.resume.exception.NoSuchEntityException;
import ikvych.resume.repository.ProfileRepository;
import ikvych.resume.service.FindProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindProfileServiceImpl implements FindProfileService {
    private Logger LOGGER = LoggerFactory.getLogger(FindProfileService.class);

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile findProfileById(Long profileId) {
        return profileRepository.findById(profileId).orElseThrow(() -> {
            String msg = String.format("Can't find profile with id: %s", profileId);
            NoSuchEntityException ex = new NoSuchEntityException(msg);
            LOGGER.error(msg, ex);
            return ex;
        });
    }

    @Override
    public Profile findProfileByUid(String uid) {
        return profileRepository.findByUid(uid).orElseThrow(() -> {
            String msg = String.format("Can't find profile with uid: %s", uid);
            NoSuchEntityException ex = new NoSuchEntityException(msg);
            LOGGER.error(msg, ex);
            return ex;
        });
    }
}
