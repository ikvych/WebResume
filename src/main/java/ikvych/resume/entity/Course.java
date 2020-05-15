package ikvych.resume.entity;

import ikvych.resume.annotation.constraints.FirstYearMonthBeforeSecondYearMonth;
import ikvych.resume.convertor.YearMonthDateAttributeConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.YearMonth;

@Entity
@Table(name = "course")
@FirstYearMonthBeforeSecondYearMonth(first = "beginDate", second = "finishDate")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Column(name = "name", nullable = false, length = 60)
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String name;

    @Column(name = "organization", nullable = false, length = 60)
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String organization;

    @Column(name = "begin_date", nullable = false, columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM")
    @Convert(converter = YearMonthDateAttributeConverter.class)
    @NotNull
    private YearMonth beginDate;

    @Column(name = "finish_date", columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM")
    @Convert(converter = YearMonthDateAttributeConverter.class)
    private YearMonth finishDate;

    @Column(name = "demo")
    private String demo;

    @Column(name = "src")
    private String src;

    @Column(name = "description")
    @NotNull
    @NotBlank
    private String description;

    @Transient
    private YearMonth currentDate = YearMonth.now();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public YearMonth getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(YearMonth finishDate) {
        this.finishDate = finishDate;
    }

    public YearMonth getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(YearMonth currentDate) {
        this.currentDate = currentDate;
    }

    public YearMonth getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(YearMonth beginDate) {
        this.beginDate = beginDate;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
