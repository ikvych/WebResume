package ikvych.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ikvych.resume.annotation.constraints.EnglishLanguage;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "skill")
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    @JsonIgnore
    private Profile profile;

    @Column(name = "category", nullable = false, length = 50)
    @NotNull
    @NotBlank
    @EnglishLanguage
    private String category;

    @Column(name = "value", nullable = false, length = 2147483647)
    @NotNull
    @NotBlank
    @EnglishLanguage
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
