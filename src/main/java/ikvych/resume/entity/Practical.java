package ikvych.resume.entity;

import ikvych.resume.annotation.constraints.FirstYearMonthBeforeSecondYearMonth;
import ikvych.resume.convertor.YearMonthDateAttributeConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.YearMonth;

@Entity
@Table(name = "practical")
@FirstYearMonthBeforeSecondYearMonth(first = "beginDate", second = "finishDate")
public class Practical implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Column(name = "position", nullable = false, length = 100)
    @NotNull
    @NotBlank
    @Size(max=100)
    private String position;

    @Column(name = "company", nullable = false, length = 100)
    @NotNull
    @NotBlank
    @Size(max=100)
    private String company;

    @Column(name = "begin_date", nullable = false, columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM")
    @Convert(converter = YearMonthDateAttributeConverter.class)
    @NotNull
    private YearMonth beginDate;

    @Column(name = "finish_date", nullable = false, columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM")
    @Convert(converter = YearMonthDateAttributeConverter.class)
    private YearMonth finishDate;

    @Column(name = "responsibilities", length = 2147483647, nullable = false)
    @NotNull
    @NotBlank
    @Size(max=255)
    private String responsibilities;

    @Column(name = "demo")
    @Size(max=255)
    private String demo;

    @Column(name = "src")
    @Size(max=255)
    private String src;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public YearMonth getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(YearMonth beginDate) {
        this.beginDate = beginDate;
    }

    public YearMonth getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(YearMonth finishDate) {
        this.finishDate = finishDate;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
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

    public YearMonth getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(YearMonth currentDate) {
        this.currentDate = currentDate;
    }
}
