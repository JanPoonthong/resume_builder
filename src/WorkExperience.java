import java.util.Date;
import java.util.Scanner;

public class WorkExperience {
    private final String companyName;
    private final String jobTitle;
    private final String startDate;
    private final String description;

    public WorkExperience(String companyName, String jobTitle, String startDate, String description) {
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.startDate = startDate;
        this.description = description;
    }


    public static WorkExperience getInfo(Scanner scan) {
        System.out.print("Enter your company name: ");
        String company = scan.nextLine();

        System.out.print("Enter your job title: ");
        String jobTitle = scan.nextLine();

        System.out.print("Enter your date Ex:(2016-2019): ");
        String startDate = scan.nextLine();

        System.out.print("Enter your job description: ");
        String jobDescription = scan.nextLine();
        return new WorkExperience(company, jobTitle, startDate, jobDescription);
    }

    public String getStartDate() {
        return startDate;
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
}
