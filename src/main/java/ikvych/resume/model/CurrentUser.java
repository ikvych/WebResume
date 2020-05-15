package ikvych.resume.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface CurrentUser {
    Long getId();

    String getPassword();

    Collection<GrantedAuthority> getAuthorities();
}
