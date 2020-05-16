package ikvych.resume.controller;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.scope.FacebookPermissions;
import com.restfb.scope.ScopeBuilder;
import com.restfb.types.User;
import ikvych.resume.entity.Profile;
import ikvych.resume.service.SocialService;
import ikvych.resume.util.SecurityUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FacebookController {

    @Value("${social.facebook.idClient}")
    private String idClient;

    @Value("${social.facebook.secret}")
    private String secret;

    private String redirectUrl;

    @Autowired
    private SocialService<User> facebookSocialService;

    @Value("${app.host}")
    public void setRedirectUrl(String appHost) {
        this.redirectUrl = appHost + "/fromFb";
    }

    private String getAuthorizeUrl() {
        ScopeBuilder scopeBuilder = new ScopeBuilder();
        scopeBuilder.addPermission(FacebookPermissions.EMAIL);
        FacebookClient client = new DefaultFacebookClient(Version.VERSION_7_0);
        return client.getLoginDialogUrl(idClient, redirectUrl, scopeBuilder);
    }

    @RequestMapping(value = "/fbLogin", method = RequestMethod.GET)
    public String fbLogin() {
        return "redirect:" + getAuthorizeUrl();
    }

    @RequestMapping(value = "/fromFb", method = RequestMethod.GET)
    public String fromFb(@RequestParam(value = "code", required = false) String code) {
        if (StringUtils.isBlank(code)) {
            return "redirect:/sign-in";
        } else {
            FacebookClient client = new DefaultFacebookClient(Version.VERSION_7_0);
            FacebookClient.AccessToken accessToken = client.obtainUserAccessToken(idClient, secret, redirectUrl, code);
            client = new DefaultFacebookClient(accessToken.getAccessToken(), Version.VERSION_7_0);
            User user = client.fetchObject("me", User.class, Parameter.with("fields", "name,email,first_name,last_name"));
            Profile profile = facebookSocialService.loginViaSocialNetwork(user);
            if (profile == null) {
                return "redirect:/sign-in";
            } else {
                SecurityUtil.authenticate(profile);
                return "redirect:/" + profile.getUid();
            }
        }
    }
}
