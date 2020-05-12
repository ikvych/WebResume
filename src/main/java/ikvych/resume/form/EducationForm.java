package ikvych.resume.form;

import ikvych.resume.entity.Education;
import ikvych.resume.entity.Hobby;

import java.io.Serializable;
import java.util.List;

public class EducationForm implements Serializable {
    private List<Education> items;

    public EducationForm() {
    }

    public EducationForm(List<Education> items) {
        this.items = items;
    }

    public List<Education> getItems() {
        return items;
    }

    public void setItems(List<Education> items) {
        this.items = items;
    }
}
