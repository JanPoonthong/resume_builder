import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        PersonalInfo personalInfo = PersonalInfo.getInfo(scan);
        WorkExperience workExperienceInfo = WorkExperience.getInfo(scan);
        Resume resume = new Resume();

        resume.addPersonalInfo(personalInfo);
        resume.addWorkExperience(workExperienceInfo);
        Resume.createResume(resume);

    }
}
