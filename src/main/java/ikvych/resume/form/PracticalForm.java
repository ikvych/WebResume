package ikvych.resume.form;

import ikvych.resume.entity.Practical;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

public class PracticalForm implements Serializable {
    @Valid
    private List<Practical> items;

    public PracticalForm() {
    }

    public PracticalForm(List<Practical> items) {
        this.items = items;
    }

    public List<Practical> getItems() {
        return items;
    }

    public void setItems(List<Practical> items) {
        this.items = items;
    }
}
