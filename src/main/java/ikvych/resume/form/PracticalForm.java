package ikvych.resume.form;

import ikvych.resume.entity.Practical;

import java.io.Serializable;
import java.util.List;

public class PracticalForm implements Serializable {
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
