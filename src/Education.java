import java.util.Date;

public class Education extends PersonalInfo {
    private String degree;
    private String fieldOfStudy;
    private String school;
    private Date startDate;
    private Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getDegree() {
        return degree;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public String getSchool() {
        return school;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
