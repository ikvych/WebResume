package ikvych.resume.util;

import ikvych.resume.entity.Profile;
import ikvych.resume.model.CurrentUser;
import ikvych.resume.model.CurrentUserImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static void authenticate(Profile profile) {
        CurrentUser currentUser = new CurrentUserImpl(profile);
        Authentication authentication = new UsernamePasswordAuthenticationToken(currentUser, currentUser.getPassword(), currentUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
