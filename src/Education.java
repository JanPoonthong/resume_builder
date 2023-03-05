import java.util.Date;
import java.util.Scanner;

public class Education {
    private String degree;
    private String school;
    private String startDate;

    public Education(String degree,
                     String school, String startDate) {
    this.degree = degree;
    this.school = school;
    this.startDate = startDate;
    }

    public static Education getInfo(Scanner scan) {
        System.out.print("Enter degree Ex: (Secondary School, Bachelor of Technology): ");
        String degree = scan.nextLine();

        System.out.print("Enter school: ");
        String school = scan.nextLine();

        System.out.print("Enter your date Ex:(2016-2019): ");
        String startDate = scan.nextLine();

        return new Education(degree, school, startDate);
    }


    public String getStartDate() {
        return startDate;
    }

    public String getDegree() {
        return degree;
    }


    public String getSchool() {
        return school;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
