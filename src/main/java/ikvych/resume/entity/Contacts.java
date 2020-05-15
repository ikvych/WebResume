package ikvych.resume.entity;

import ikvych.resume.annotation.constraints.EnglishLanguage;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.servlet.annotation.HttpConstraint;
import java.io.Serializable;

@Embeddable
public class Contacts implements Serializable {

    @Column(name = "skype", length = 80)
    @EnglishLanguage
    private String skype;

    @Column(name = "faxebook")
    @EnglishLanguage
    @URL(host = "facebook.com")
    private String facebook;

    @Column(name = "linkedin")
    @EnglishLanguage
    @URL(host = "linkedin.com")
    private String linkedin;

    @Column(name = "github")
    @EnglishLanguage
    @URL(host = "github.com")
    private String github;

    @Column(name = "stackoverflow")
    @EnglishLanguage
    @URL(host = "stackoverflow.com")
    private String stackoverflow;

    public Contacts() {
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getStackoverflow() {
        return stackoverflow;
    }

    public void setStackoverflow(String stackoverflow) {
        this.stackoverflow = stackoverflow;
    }
}
