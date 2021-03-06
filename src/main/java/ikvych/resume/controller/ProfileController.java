package ikvych.resume.controller;

import ikvych.resume.entity.Profile;
import ikvych.resume.model.CurrentUserImpl;
import ikvych.resume.service.FindProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/my-profile", method = RequestMethod.GET)
    public String myProfile(@AuthenticationPrincipal CurrentUserImpl currentUser, Model model) {
        Profile profile = profileService.findProfileById(currentUser.getId());
        model.addAttribute("profile", profile);
        return "profile";
    }

}
