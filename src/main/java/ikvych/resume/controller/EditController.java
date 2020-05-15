package ikvych.resume.controller;

import ikvych.resume.entity.Contacts;
import ikvych.resume.entity.Profile;
import ikvych.resume.form.*;
import ikvych.resume.model.LanguageLevel;
import ikvych.resume.model.LanguageType;
import ikvych.resume.service.EditProfileService;
import ikvych.resume.service.FindProfileService;
import ikvych.resume.service.StaticDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;

@Controller
public class EditController {

    @Autowired
    private EditProfileService editProfileService;

    @Autowired
    private FindProfileService findProfileService;

    @Autowired
    private StaticDataService staticDataService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LanguageType.class, LanguageType.getPropertyEditor());
        binder.registerCustomEditor(LanguageLevel.class,LanguageLevel.getPropertyEditor());
    }

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
    public String saveContacts(@Valid @ModelAttribute("contacts") Contacts contacts, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit/contacts";
        }
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/skills", method = RequestMethod.GET)
    public String getSkills(Model model) {
        SkillsForm skills = new SkillsForm(editProfileService.findAllSkillByProfileId(5L));
        model.addAttribute("skills", skills);
        return "edit/skills";
    }

    @RequestMapping(value = "/edit/skills", method = RequestMethod.POST)
    public String saveSkills(@Valid @ModelAttribute("skills") SkillsForm skills, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit/skills";
        }
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/practical", method = RequestMethod.GET)
    public String getPractical(Model model) {
        PracticalForm practicals = new PracticalForm(editProfileService.findAllPracticalByProfileId(5L));
        model.addAttribute("practicals", practicals);
        return "edit/experience";
    }

    @RequestMapping(value = "/edit/practical", method = RequestMethod.POST)
    public String savePractical(@Valid @ModelAttribute("practicals") PracticalForm practicals, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit/experience";
        }
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/courses", method = RequestMethod.GET)
    public String getCourses(Model model) {
        CourseForm courses = new CourseForm(editProfileService.findAllCourseByProfileId(5L));
        model.addAttribute("courses", courses);
        return "edit/courses";
    }

    @RequestMapping(value = "/edit/courses", method = RequestMethod.POST)
    public String saveCourses(@Valid @ModelAttribute("courses") CourseForm courses, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit/courses";
        }
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/languages", method = RequestMethod.GET)
    public String getLanguages(Model model) {
        LanguagesForm languages = new LanguagesForm(editProfileService.findAllLanguageByProfileId(5L));
        model.addAttribute("languages", languages);
        model.addAttribute("languageTypes",  EnumSet.allOf(LanguageType.class));
        model.addAttribute("languageLevels", EnumSet.allOf(LanguageLevel.class));
        return "edit/languages";
    }

    @RequestMapping(value = "/edit/languages", method = RequestMethod.POST)
    public String saveLanguages(@Valid @ModelAttribute("languages") LanguagesForm languages, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("languageTypes",  EnumSet.allOf(LanguageType.class));
            model.addAttribute("languageLevels", EnumSet.allOf(LanguageLevel.class));
            return "edit/languages";
        }
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/hobby", method = RequestMethod.GET)
    public String getHobby(Model model) {
        HobbyForm hobby = new HobbyForm(editProfileService.findAllHobbyByProfileId(5L));
        model.addAttribute("hobbys", hobby);
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
        model.addAttribute("years", staticDataService.getYearsForEducation());
        return "edit/educations";
    }

    @RequestMapping(value = "/edit/educations", method = RequestMethod.POST)
    public String saveEducations(@Valid @ModelAttribute("educations") EducationForm educations, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("years", staticDataService.getYearsForEducation());
            return "edit/educations";
        }
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/certificates", method = RequestMethod.GET)
    public String getCertificates(Model model) {
        CertificateForm certificates = new CertificateForm(editProfileService.findAllCertificateByProfileId(5L));
        model.addAttribute("certificates", certificates);
        return "edit/certificates";
    }

    @RequestMapping(value = "/edit/certificates", method = RequestMethod.POST)
    public String saveCertificates(@ModelAttribute("certificates") CertificateForm certificates, Model model, @RequestParam("inpFile") MultipartFile inpFile) {
        return "redirect:/carla-walton";
    }

    @RequestMapping(value = "/edit/certificates/upload", method = RequestMethod.POST)
    public @ResponseBody Response uploadCertificate(@RequestParam(value = "file", required = false) MultipartFile file) {
        return new Response();
    }

    static class Response {
        String certificateName = "CertifacateName";
        String smallUrl = "/media/certificates/4b1dea50-fdd0-4570-8fbb-92122fb27d5f-small.jpg";
        String largeUrl = "/media/certificates/4b1dea50-fdd0-4570-8fbb-92122fb27d5f.jpg";

        public String getCertificateName() {
            return certificateName;
        }

        public void setCertificateName(String certificateName) {
            this.certificateName = certificateName;
        }

        public String getSmallUrl() {
            return smallUrl;
        }

        public void setSmallUrl(String smallUrl) {
            this.smallUrl = smallUrl;
        }

        public String getLargeUrl() {
            return largeUrl;
        }

        public void setLargeUrl(String largeUrl) {
            this.largeUrl = largeUrl;
        }
    }

}
