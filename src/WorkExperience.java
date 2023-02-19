import java.util.Date;

public class WorkExperience extends PersonalInfo {
    private String CompanyName;
    private String jobTitle;
    private Date startDate;
    private Date endDate;
    private String description;

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public String getDescription() {
        return description;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
