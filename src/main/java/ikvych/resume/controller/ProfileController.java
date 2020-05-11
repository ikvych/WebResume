package ikvych.resume.controller;

import ikvych.resume.entity.Profile;
import ikvych.resume.repository.ProfileRepository;
import ikvych.resume.service.FindProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

@Controller
public class ProfileController {

    @Autowired
    private FindProfileService profileService;

    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public String getProfile(@PathVariable("uid") String uid, Model model) {
        Profile profile = profileService.findProfileByUid(uid);
        model.addAttribute("profile", profile);
        return "profile";
    }

}
