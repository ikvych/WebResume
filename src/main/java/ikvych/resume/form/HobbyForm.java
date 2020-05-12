package ikvych.resume.form;

import ikvych.resume.entity.Hobby;
import ikvych.resume.entity.Language;

import java.io.Serializable;
import java.util.List;

public class HobbyForm implements Serializable {
    private List<Hobby> items;

    public HobbyForm() {
    }

    public HobbyForm(List<Hobby> items) {
        this.items = items;
    }

    public List<Hobby> getItems() {
        return items;
    }

    public void setItems(List<Hobby> items) {
        this.items = items;
    }
}
