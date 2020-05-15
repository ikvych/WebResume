package ikvych.resume.model;

import ikvych.resume.entity.Profile;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class CurrentUserImpl extends User implements CurrentUser {
    private Long id;

    public CurrentUserImpl(Profile profile) {
        super(profile.getUid(), profile.getPassword(), Collections.singleton(new SimpleGrantedAuthority(Constants.USER)));
        this.id = profile.getId();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CurrentUserImpl{" +
                "id=" + id +
                '}';
    }
}
