package ikvych.resume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PublicController {

    @RequestMapping(value = "/sign-in", method = RequestMethod.GET)
    public String getSignIn() {
        return "sign-in";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.GET)
    public String getSignUp() {
        return "sign-up";
    }
}
