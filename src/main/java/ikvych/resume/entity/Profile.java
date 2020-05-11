package ikvych.resume.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "uid", unique = true, nullable = false, length = 100)
    private String uid;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "birth")
    private LocalDate birthDay;

    @Column(name = "phone", unique = true, length = 20)
    private String phone;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "country", length = 60)
    private String country;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "objective", length = 2147483647)
    private String objective;

    @Column(name = "summary", length = 2147483647)
    private String summary;

    @Column(name = "large_photo")
    private String largePhoto;

    @Column(name = "small_photo")
    private String smallPhoto;

    @Column(name = "info", length = 2147483647)
    private String info;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "completed", nullable = false)
    private Boolean completed;

    @Column(name = "created", insertable = false)
    private LocalDateTime created;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "facebook", column = @Column(name = "facebook")),
            @AttributeOverride( name = "github", column = @Column(name = "github")),
            @AttributeOverride( name = "linkedin", column = @Column(name = "linkedin")),
            @AttributeOverride( name = "skype", column = @Column(name = "skype")),
            @AttributeOverride( name = "stackoverflow", column = @Column(name = "stackoverflow"))
    })
    private Contacts contacts;

    @OneToMany(mappedBy = "profile", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<Certificate> certificates;

    @OneToMany(mappedBy = "profile", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("finishYear DESC, beginYear DESC, id DESC")
    private List<Education> educations;

    @OneToMany(mappedBy = "profile", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("name ASC")
    private List<Hobby> hobbies;

    @OneToMany(mappedBy = "profile", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<Language> languages;

    @OneToMany(mappedBy = "profile", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("beginDate DESC")
    private List<Practical> practicals;

    @OneToMany(mappedBy = "profile", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("id ASC")
    private List<Skill> skills;

    @OneToMany(mappedBy = "profile", cascade={CascadeType.MERGE, CascadeType.PERSIST})
    private List<Course> courses;

    @Transient
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLargePhoto() {
        return largePhoto;
    }

    public void setLargePhoto(String largePhoto) {
        this.largePhoto = largePhoto;
    }

    public String getSmallPhoto() {
        return smallPhoto;
    }

    public void setSmallPhoto(String smallPhoto) {
        this.smallPhoto = smallPhoto;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Practical> getPracticals() {
        return practicals;
    }

    public void setPracticals(List<Practical> practicals) {
        this.practicals = practicals;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Integer getAge() {
        return Period.between(birthDay, LocalDate.now()).getYears();
    }
}
