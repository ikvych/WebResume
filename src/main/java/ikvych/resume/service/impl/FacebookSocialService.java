package ikvych.resume.service.impl;

import com.restfb.types.User;
import ikvych.resume.entity.Profile;
import ikvych.resume.exception.NoSuchEntityException;
import ikvych.resume.service.FindProfileService;
import ikvych.resume.service.SocialService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacebookSocialService implements SocialService<User> {

    @Autowired
    private FindProfileService findProfileService;

    @Override
    public Profile loginViaSocialNetwork(User model) {
        if (StringUtils.isNotBlank(model.getEmail())) {
            try {
                return findProfileService.findProfileByEmail(model.getEmail());
            } catch (NoSuchEntityException ex) {
                return null;
            }
        }
        return null;
    }
}
