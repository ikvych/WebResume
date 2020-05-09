package ikvych.resume.controller;

import ikvych.resume.entity.Profile;
import ikvych.resume.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

@Controller
public class PublicController {

    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfile() {
        return "profile";
    }

}
