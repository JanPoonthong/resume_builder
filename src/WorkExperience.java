import java.util.Date;
import java.util.Scanner;

public class WorkExperience {
    private String companyName;
    private String jobTitle;
    private String startDate;
    private String endDate;
    private String description;

    public WorkExperience(String companyName, String jobTitle, String startDate, String endDate, String description) {
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }


    public static WorkExperience getInfo(Scanner scan) {
        System.out.print("Enter your job title: ");
        String jobTitle = scan.nextLine();

        System.out.print("Enter your company name: ");
        String company = scan.nextLine();

        System.out.print("Enter your start date: ");
        String startDate = scan.nextLine();

        System.out.print("Enter your end date: ");
        String endDate = scan.nextLine();

        System.out.print("Enter your job description: ");
        String jobDescription = scan.nextLine();
        return new WorkExperience(company, jobTitle, startDate, endDate, jobDescription);
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDescription() {
        return description;
    }

    public String getJobTitle() {
        return jobTitle;
    }

//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.endDate = endDate;
//    }
//
//    public void setCompanyName(String companyName) {
//        CompanyName = companyName;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setJobTitle(String jobTitle) {
//        this.jobTitle = jobTitle;
//    }
}
