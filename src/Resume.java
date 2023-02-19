import java.util.List;

public class Resume {
    private PersonalInfo personalInfo;
    private List<Education> education;
    private List<WorkExperience> workExperience;
    private List<Skill> skill;

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public List<Education> getEducation() {
        return education;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public List<WorkExperience> getWorkExperience() {
        return workExperience;
    }
}
