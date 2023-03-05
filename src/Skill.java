import java.util.Scanner;

public class Skill {
    private final String skillName;

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public static Skill getInfo(Scanner scan) {
        System.out.print("Enter skill: ");
        String skill = scan.nextLine();

        return new Skill(skill);
    }

    public String getSkillName() {
        return skillName;
    }
}
