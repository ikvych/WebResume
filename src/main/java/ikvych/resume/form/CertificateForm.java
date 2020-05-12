package ikvych.resume.form;

import ikvych.resume.entity.Certificate;
import ikvych.resume.entity.Contacts;

import java.io.Serializable;
import java.util.List;

public class CertificateForm implements Serializable {
    private List<Certificate> items;

    public CertificateForm() {
    }

    public CertificateForm(List<Certificate> items) {
        this.items = items;
    }

    public List<Certificate> getItems() {
        return items;
    }

    public void setItems(List<Certificate> items) {
        this.items = items;
    }
}
