package ikvych.resume.service.impl;

import ikvych.resume.entity.*;
import ikvych.resume.exception.NoSuchEntityException;
import ikvych.resume.repository.*;
import ikvych.resume.service.EditProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditProfileServiceImpl implements EditProfileService {
    private final Logger LOGGER = LoggerFactory.getLogger(EditProfileServiceImpl.class);

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
        return hobbyRepository.findAllByProfileId(profileId).orElseThrow(() -> {
            String msg = String.format("Can't find hobby list by profileId: %d", profileId);
            NoSuchEntityException ex = new NoSuchEntityException(msg);
            LOGGER.error(msg, ex);
            return ex;
        });
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
