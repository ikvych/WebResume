package ikvych.resume.form;

import ikvych.resume.entity.Language;
import ikvych.resume.entity.Skill;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

public class LanguagesForm implements Serializable {
    @Valid
    private List<Language> items;

    public LanguagesForm() {
    }

    public LanguagesForm(List<Language> items) {
        this.items = items;
    }

    public List<Language> getItems() {
        return items;
    }

    public void setItems(List<Language> items) {
        this.items = items;
    }
}
