public class Skill extends PersonalInfo {
    private String skillName;
    private int skillLevel;

    public int getSkillLevel() {
        return skillLevel;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
