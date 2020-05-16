package ikvych.resume.service;

import ikvych.resume.entity.Profile;

public interface SocialService<T> {

    Profile loginViaSocialNetwork(T model);
}
