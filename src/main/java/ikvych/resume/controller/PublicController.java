package ikvych.resume.controller;

import ikvych.resume.entity.Profile;
import ikvych.resume.form.SignUpForm;
import ikvych.resume.service.EditProfileService;
import ikvych.resume.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PublicController {

    @Autowired
    private EditProfileService editProfileService;

    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public String getSignIn() {
        return "sign-in";
    }

    @RequestMapping(value = "/sign-in-failed", method = RequestMethod.GET)
    public String getSignInFailed() {
        return "sign-in-failed";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public String getSignUp(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "sign-up";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String createNewUser(@Valid @ModelAttribute("signUpForm") SignUpForm signUpForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "sign-up";
        }
        Profile profile = editProfileService.createNewProfile(signUpForm);
        SecurityUtil.authenticate(profile);
        return "redirect:/my-profile";
    }
}
