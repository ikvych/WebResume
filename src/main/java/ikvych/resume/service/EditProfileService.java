package ikvych.resume.service;

import ikvych.resume.entity.*;
import ikvych.resume.form.SignUpForm;
import ikvych.resume.model.CurrentUser;

import java.util.List;

public interface EditProfileService {

    Profile createNewProfile(SignUpForm signUpForm);

    List<Practical> findAllPracticalByProfileId(Long profileId);

    List<Skill> findAllSkillByProfileId(Long profileId);

    List<Language> findAllLanguageByProfileId(Long profileId);

    List<Hobby> findAllHobbyByProfileId(Long profileId);

    List<Education> findAllEducationByProfileId(Long profileId);

    List<Course> findAllCourseByProfileId(Long profileId);

    List<Certificate> findAllCertificateByProfileId(Long profileId);
}
