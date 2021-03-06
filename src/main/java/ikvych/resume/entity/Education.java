package ikvych.resume.entity;

import ikvych.resume.annotation.constraints.FirstFieldLessThanSecond;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "education")
@FirstFieldLessThanSecond(first = "beginYear", second = "finishYear")
public class Education implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Column(name = "summary", nullable = false, length = 100)
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String summary;

    @Column(name = "begin_year", nullable = false)
    private Integer beginYear;

    @Column(name = "finish_year")
    private Integer finishYear;

    @Column(name = "university", length = 2147483647, nullable = false)
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String university;

    @Column(name = "faculty", nullable = false)
    @NotNull
    @NotBlank
    @Size(max = 255)
    private String faculty;

    @Transient
    private LocalDate currentDate = LocalDate.now();

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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getBeginYear() {
        return beginYear;
    }

    public void setBeginYear(Integer beginYear) {
        this.beginYear = beginYear;
    }

    public Integer getFinishYear() {
        return finishYear;
    }

    public void setFinishYear(Integer finishYear) {
        this.finishYear = finishYear;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }
}
