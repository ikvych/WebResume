package ikvych.resume.controller;

import ikvych.resume.entity.Profile;
import ikvych.resume.form.SignUpForm;
import ikvych.resume.model.Constants;
import ikvych.resume.service.EmailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import ikvych.resume.service.EditProfileService;
import ikvych.resume.service.FindProfileService;
import ikvych.resume.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static ikvych.resume.model.Constants.MAX_PROFILES_PER_PAGE;

@Controller
public class PublicController {

    @Autowired
    private FindProfileService findProfileService;

    @Autowired
    private EditProfileService editProfileService;

    @Autowired
    private EmailService emailService;

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
        if (signUpForm.getRememberMe()) {
            SecurityUtil.authenticateWithRememberMe(profile);
        } else {
            SecurityUtil.authenticate(profile);
        }
        return "redirect:/my-profile";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    private String welcome(Model model) {
        Page<Profile> profiles = findProfileService.findAll(PageRequest.of(0, MAX_PROFILES_PER_PAGE, Sort.by("id")));
        model.addAttribute("profiles", profiles.getContent());
        model.addAttribute("page", profiles);
        return "welcome";
    }

    @RequestMapping(value = "/fragment/more", method = RequestMethod.GET)
    private String loadMoreFragment(Model model,
                                    @RequestParam(value = "query", required = false) String query,
                                    @PageableDefault(size = Constants.MAX_PROFILES_PER_PAGE) @SortDefault(sort = "id") Pageable pageable) {
        Page<Profile> profiles;
        if (StringUtils.isNotBlank(query)) {
            profiles = findProfileService.findAllBySearchQuery(query, pageable);
        } else {
            profiles = findProfileService.findAll(pageable);
        }
        model.addAttribute("profiles", profiles.getContent());
        return "fragment/profile-list";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(Model model,
                         @RequestParam(value = "query", required = false) String query,
                         @PageableDefault(size = MAX_PROFILES_PER_PAGE) @SortDefault(sort = "id") Pageable pageable) throws UnsupportedEncodingException {
        if (StringUtils.isBlank(query)) {
            return "redirect:/welcome";
        } else {
            Page<Profile> profiles = findProfileService.findAllBySearchQuery(query, pageable);
            model.addAttribute("profiles", profiles.getContent());
            model.addAttribute("page", profiles);
            model.addAttribute("query", URLDecoder.decode(query, "UTF-8"));
            return "search-result";
        }
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    private String sendMessage() {
        emailService.sendMessage("ikvuch@gmail.com", "Test", "Test message");
        return "message";
    }
}
