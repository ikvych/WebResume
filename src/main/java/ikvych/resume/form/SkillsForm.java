package ikvych.resume.form;

import ikvych.resume.entity.Practical;
import ikvych.resume.entity.Skill;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

public class SkillsForm implements Serializable {
    @Valid
    private List<Skill> items;

    public SkillsForm() {
    }

    public SkillsForm(List<Skill> items) {
        this.items = items;
    }

    public List<Skill> getItems() {
        return items;
    }

    public void setItems(List<Skill> items) {
        this.items = items;
    }
}
