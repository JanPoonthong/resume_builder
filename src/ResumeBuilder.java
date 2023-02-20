import java.util.List;

public class ResumeBuilder {
    private PersonalInfo personalInfo;
    private List<Education> education;
    private List<WorkExperience> workExperience;
    private List<Skill> skills;

    public Resume createResume() {
        return null;
    }

    public void addPersonalInfo(PersonalInfo info) {
        personalInfo = info;
    }

    public void addEducation(Education edu) {
        education.add(edu);
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void addWorkExperience(WorkExperience exp) {
        workExperience.add(exp);
    }
}