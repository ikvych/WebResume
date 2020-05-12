package ikvych.resume.controller;

import ikvych.resume.entity.Contacts;
import ikvych.resume.entity.Profile;
import ikvych.resume.form.*;
import ikvych.resume.service.EditProfileService;
import ikvych.resume.service.FindProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class EditController {

    @Autowired
    private EditProfileService editProfileService;

    @Autowired
    private FindProfileService findProfileService;

    @RequestMapping(value = "/edit/profile", method = RequestMethod.GET)
    public String getProfile(Model model) {
        model.addAttribute("profile", findProfileService.findProfileById(6L));
        return "edit/profile";
    }

    @RequestMapping(value = "/edit/profile", method = RequestMethod.POST)
    public String saveProfile(@Valid @ModelAttribute("profile") Profile profile, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit/profile";
        }
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/contacts", method = RequestMethod.GET)
    public String getContacts(Model model) {
        model.addAttribute("contacts", findProfileService.findProfileById(6L).getContacts());
        return "edit/contacts";
    }

    @RequestMapping(value = "/edit/contacts", method = RequestMethod.POST)
    public String saveContacts(@ModelAttribute("contacts") Contacts contacts, Model model) {
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/practical", method = RequestMethod.GET)
    public String getPractical(Model model) {
        PracticalForm practicals = new PracticalForm(editProfileService.findAllPracticalByProfileId(5L));
        model.addAttribute("practicals", practicals);
        return "edit/experience";
    }

    @RequestMapping(value = "/edit/practical", method = RequestMethod.POST)
    public String savePractical(@ModelAttribute("practicals") PracticalForm practicals, Model model) {
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/skills", method = RequestMethod.GET)
    public String getSkills(Model model) {
        SkillsForm skills = new SkillsForm(editProfileService.findAllSkillByProfileId(5L));
        model.addAttribute("skills", skills);
        return "edit/skills";
    }

    @RequestMapping(value = "/edit/skills", method = RequestMethod.POST)
    public String saveSkills(@ModelAttribute("skills") SkillsForm skills, Model model) {
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/languages", method = RequestMethod.GET)
    public String getLanguages(Model model) {
        LanguagesForm languages = new LanguagesForm(editProfileService.findAllLanguageByProfileId(5L));
        model.addAttribute("languages", languages);
        return "edit/languages";
    }

    @RequestMapping(value = "/edit/languages", method = RequestMethod.POST)
    public String saveLanguages(@ModelAttribute("languages") LanguagesForm languages, Model model) {
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/hobby", method = RequestMethod.GET)
    public String getHobby(Model model) {
        HobbyForm hobby = new HobbyForm(editProfileService.findAllHobbyByProfileId(5L));
        model.addAttribute("hobby", hobby);
        return "edit/hobby";
    }

    @RequestMapping(value = "/edit/hobby", method = RequestMethod.POST)
    public String saveHobby(@ModelAttribute("hobby") HobbyForm hobby, Model model) {
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/educations", method = RequestMethod.GET)
    public String getEducations(Model model) {
        EducationForm educations = new EducationForm(editProfileService.findAllEducationByProfileId(5L));
        model.addAttribute("educations", educations);
        return "edit/educations";
    }

    @RequestMapping(value = "/edit/educations", method = RequestMethod.POST)
    public String saveEducations(@ModelAttribute("educations") EducationForm educations, Model model) {
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/courses", method = RequestMethod.GET)
    public String getCourses(Model model) {
        CourseForm courses = new CourseForm(editProfileService.findAllCourseByProfileId(5L));
        model.addAttribute("courses", courses);
        return "edit/courses";
    }

    @RequestMapping(value = "/edit/courses", method = RequestMethod.POST)
    public String saveCourses(@ModelAttribute("courses") CourseForm courses, Model model) {
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/certificates", method = RequestMethod.GET)
    public String getCertificates(Model model) {
        CertificateForm certificates = new CertificateForm(editProfileService.findAllCertificateByProfileId(5L));
        model.addAttribute("certificates", certificates);
        return "edit/certificates";
    }

    @RequestMapping(value = "/edit/certificates", method = RequestMethod.POST)
    public String saveCertificates(@ModelAttribute("certificates") CertificateForm certificates, Model model) {
        return "redirect:/carla-walton";
    }

}
