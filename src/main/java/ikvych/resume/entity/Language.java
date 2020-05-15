package ikvych.resume.entity;

import ikvych.resume.annotation.constraints.EnglishLanguage;
import ikvych.resume.convertor.LanguageLevelAttributeConverter;
import ikvych.resume.convertor.LanguageTypeAttributeConverter;
import ikvych.resume.model.LanguageLevel;
import ikvych.resume.model.LanguageType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "language")
public class Language implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Column(name = "name", nullable = false, length = 30)
    @NotNull
    @NotBlank
    @Size(max = 30)
    @EnglishLanguage(withNumbers = false, withPunctuations = false, withSpechSymbols = false)
    private String name;

    @Column(name = "level", nullable = false, length = 18)
    @Convert(converter = LanguageLevelAttributeConverter.class)
    @NotNull
    private LanguageLevel level;

    @Column(name = "type", nullable = false, length = 7)
    @Convert(converter = LanguageTypeAttributeConverter.class)
    @NotNull
    private LanguageType type;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LanguageLevel getLevel() {
        return level;
    }

    public void setLevel(LanguageLevel level) {
        this.level = level;
    }

    public LanguageType getType() {
        return type;
    }

    public void setType(LanguageType type) {
        this.type = type;
    }
}
