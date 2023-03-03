import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        PersonalInfo personalInfo = PersonalInfo.getInfo(scan);
        ImageInCircle imageInCircle = new ImageInCircle();
        imageInCircle.cropImageIntoCircle(personalInfo.getProfileImagePath());
        Resume resume = new Resume();
        System.out.print("Type 'done' to stop adding work experience; To continue type 'start': ");
        String userExpConfirmation = scan.nextLine();

        WorkExperience workExperienceInfo;

        while (userExpConfirmation.equals("start")) {
            workExperienceInfo = WorkExperience.getInfo(scan);
            resume.addWorkExperience(workExperienceInfo);
            System.out.print("Type 'done' to stop adding work experience; To continue type 'start': ");
            userExpConfirmation = scan.nextLine();
        }
        resume.addPersonalInfo(personalInfo);
        Resume.createResume(resume);
    }
}
