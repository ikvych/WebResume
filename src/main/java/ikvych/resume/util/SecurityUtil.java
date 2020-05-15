package ikvych.resume.util;

import ikvych.resume.entity.Profile;
import ikvych.resume.model.CurrentUser;
import ikvych.resume.model.CurrentUserImpl;
import ikvych.resume.service.impl.RememberMeService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SecurityUtil {

    public static Authentication authenticate(Profile profile) {
        CurrentUser currentUser = new CurrentUserImpl(profile);
        Authentication authentication = new UsernamePasswordAuthenticationToken(currentUser, currentUser.getPassword(), currentUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return authentication;
    }

    public static void authenticateWithRememberMe(Profile profile) {
        Authentication authentication = authenticate(profile);
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        WebApplicationContext ctx = (WebApplicationContext) request.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        RememberMeService rememberMeService = ctx.getBean(RememberMeService.class);
        rememberMeService.createAutoLoginToken(request, requestAttributes.getResponse(), authentication);
    }
}
