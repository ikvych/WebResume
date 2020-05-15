package ikvych.resume.service.impl;

import ikvych.resume.entity.*;
import ikvych.resume.exception.NoSuchEntityException;
import ikvych.resume.form.SignUpForm;
import ikvych.resume.repository.*;
import ikvych.resume.service.EditProfileService;
import ikvych.resume.service.StaticDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EditProfileServiceImpl implements EditProfileService {
    private final Logger LOGGER = LoggerFactory.getLogger(EditProfileServiceImpl.class);

    @Autowired
    private StaticDataService staticDataService;

    @Autowired
    private PracticalRepository practicalRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private HobbyRepository hobbyRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile createNewProfile(SignUpForm signUpForm) {
        Profile profile = new Profile();
        profile.setFirstName(signUpForm.getFirstName());
        profile.setLastName(signUpForm.getLastName());
        profile.setPassword(signUpForm.getPassword());
        profile.setUid(signUpForm.getFirstName().toLowerCase() + "-" + signUpForm.getLastName().toLowerCase());
        profile = profileRepository.save(profile);
        return profile;
    }

    @Override
    public List<Practical> findAllPracticalByProfileId(Long profileId) {
        return practicalRepository.findAllByProfileId(profileId).orElseThrow(() -> {
            String msg = String.format("Can't find practical list by profileId: %d", profileId);
            NoSuchEntityException ex = new NoSuchEntityException(msg);
            LOGGER.error(msg, ex);
            return ex;
        });
    }

    @Override
    public List<Skill> findAllSkillByProfileId(Long profileId) {
        return skillRepository.findAllByProfileId(profileId).orElseThrow(() -> {
            String msg = String.format("Can't find skill list by profileId: %d", profileId);
            NoSuchEntityException ex = new NoSuchEntityException(msg);
            LOGGER.error(msg, ex);
            return ex;
        });
    }

    @Override
    public List<Language> findAllLanguageByProfileId(Long profileId) {
        return languageRepository.findAllByProfileId(profileId).orElseThrow(() -> {
            String msg = String.format("Can't find language list by profileId: %d", profileId);
            NoSuchEntityException ex = new NoSuchEntityException(msg);
            LOGGER.error(msg, ex);
            return ex;
        });
    }

    @Override
    public List<Hobby> findAllHobbyByProfileId(Long profileId) {
        List<Hobby> profileHobbies = hobbyRepository.findAllByProfileId(profileId).orElseThrow(() -> {
            String msg = String.format("Can't find hobby list by profileId: %d", profileId);
            NoSuchEntityException ex = new NoSuchEntityException(msg);
            LOGGER.error(msg, ex);
            return ex;
        });
        List<Hobby> hobbies = new ArrayList<>();
        for (Hobby h : staticDataService.listAllHobbies()) {
            boolean selected = profileHobbies.contains(h);
            hobbies.add(new Hobby(h.getName(), selected));
        }
        return hobbies;
    }

    @Override
    public List<Education> findAllEducationByProfileId(Long profileId) {
        return educationRepository.findAllByProfileId(profileId).orElseThrow(() -> {
            String msg = String.format("Can't find education list by profileId: %d", profileId);
            NoSuchEntityException ex = new NoSuchEntityException(msg);
            LOGGER.error(msg, ex);
            return ex;
        });
    }

    @Override
    public List<Course> findAllCourseByProfileId(Long profileId) {
        return courseRepository.findAllByProfileId(profileId).orElseThrow(() -> {
            String msg = String.format("Can't find course list by profileId: %d", profileId);
            NoSuchEntityException ex = new NoSuchEntityException(msg);
            LOGGER.error(msg, ex);
            return ex;
        });
    }

    @Override
    public List<Certificate> findAllCertificateByProfileId(Long profileId) {
        return certificateRepository.findAllByProfileId(profileId).orElseThrow(() -> {
            String msg = String.format("Can't find certificate list by profileId: %d", profileId);
            NoSuchEntityException ex = new NoSuchEntityException(msg);
            LOGGER.error(msg, ex);
            return ex;
        });
    }
}
