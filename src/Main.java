import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        PersonalInfo personalInfo = PersonalInfo.getInfo(scan);
        ImageInCircle imageInCircle = new ImageInCircle();
        imageInCircle.cropImageIntoCircle(personalInfo.getProfileImagePath());
        Resume resume = new Resume();
        System.out.println("--------------------------EXPERIENCE--------------------------");
        System.out.print("Type 'done' to stop adding work experience; To continue type 'start': ");
        String userExpConfirmationForExperience = scan.nextLine();

        WorkExperience workExperienceInfo;

        while (userExpConfirmationForExperience.equals("start")) {
            workExperienceInfo = WorkExperience.getInfo(scan);
            resume.addWorkExperience(workExperienceInfo);
            System.out.print("Type 'done' to stop adding work experience; To continue type 'start': ");
            userExpConfirmationForExperience = scan.nextLine();
        }


        System.out.println("--------------------------SKILLS--------------------------");

        System.out.print("Type 'done' to stop adding skills; To continue type 'start': ");
        String userExpConfirmationForSkills = scan.nextLine();

        Skill skill;

        int countSkill = 0;
        while (userExpConfirmationForSkills.equals("start")) {
            skill = Skill.getInfo(scan);
            resume.addSkill(skill);
            countSkill++;
            if (countSkill >= 8) break;
            System.out.print("Type 'done' to stop adding skills; To continue type 'start': ");
            userExpConfirmationForSkills = scan.nextLine();
        }

        System.out.println("--------------------------EDUCATION--------------------------");

        System.out.print("Type 'done' to stop adding skills; To continue type 'start': ");
        String userExpConfirmationForEducation = scan.nextLine();

        Education educations;

        int countEducation = 0;
        while (userExpConfirmationForEducation.equals("start")) {
            educations = Education.getInfo(scan);
            resume.addEducation(educations);
            countEducation++;
            if (countEducation >= 2) break;
            System.out.print("Type 'done' to stop adding education; To continue type 'start': ");
            userExpConfirmationForEducation = scan.nextLine();
        }

        resume.addPersonalInfo(personalInfo);
        Resume.createResume(resume);
    }
}
