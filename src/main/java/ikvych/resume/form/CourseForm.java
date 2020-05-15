package ikvych.resume.form;

import ikvych.resume.entity.Course;
import ikvych.resume.entity.Education;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

public class CourseForm implements Serializable {
    @Valid
    private List<Course> items;

    public CourseForm() {
    }

    public CourseForm(List<Course> items) {
        this.items = items;
    }

    public List<Course> getItems() {
        return items;
    }

    public void setItems(List<Course> items) {
        this.items = items;
    }
}
