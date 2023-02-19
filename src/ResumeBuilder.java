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

    public void addEducation(List<Education> edu) {
        education = edu;
    }

    public void addSkill(List<Skill> skill) {
        skills = skill;
    }

    public void addWorkExperience(List<WorkExperience> exp) {
        workExperience = exp;
    }
}
//

