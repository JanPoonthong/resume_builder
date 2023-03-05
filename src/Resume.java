import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.pdfbox.pdmodel.graphics.state.RenderingMode;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Resume {
    private PersonalInfo personalInfo;
    private final ArrayList<Education> education = new ArrayList<>();
    private final ArrayList<WorkExperience> workExperience = new ArrayList<>();
    private final ArrayList<Skill> skills = new ArrayList<>();

    public Resume() {
    }

    public static void createResume(Resume resume) throws IOException {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        PDFont font = PDType1Font.HELVETICA_BOLD;

        contentStream.setFont(font, 35);
        contentStream.setNonStrokingColor(Color.BLACK);

        contentStream.drawImage(PDImageXObject.createFromFile("assets/banner.png",
                document), 0, 620, 700, 140);

        contentStream.drawImage(PDImageXObject.createFromFile("assets/" + resume.getPersonalInfo().getProfileImagePath().substring(0, resume.getPersonalInfo().getProfileImagePath().lastIndexOf(".")) + ".png",
                document), 490, 580, 120, 150);

        contentStream.drawImage(PDImageXObject.createFromFile("assets/phone_icon.png",
                document), 31, 585, 20, 20);

        contentStream.drawImage(PDImageXObject.createFromFile("assets/mail_icon.png",
                document), 30, 560, 20, 15);

        contentStream.drawImage(PDImageXObject.createFromFile("assets/location_icon.png",
                document), 30, 530, 20, 20);

        contentStream.drawImage(PDImageXObject.createFromFile("assets/website_icon.png",
                document), 30, 500, 20, 20);

        contentStream.beginText();
        contentStream.newLineAtOffset(30, 710);
        contentStream.showText(resume.getPersonalInfo().getFullName().toUpperCase());
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 20);
        contentStream.newLineAtOffset(30, 660);
        contentStream.setCharacterSpacing(7);
        contentStream.showText(resume.getPersonalInfo().getPosition().toUpperCase());
        contentStream.endText();

        contentStream.setCharacterSpacing(0);
        contentStream.setNonStrokingColor(Color.GRAY);

        contentStream.beginText();
        contentStream.setFont(font, 12);
        contentStream.newLineAtOffset(60, 591);
        contentStream.showText(resume.getPersonalInfo().getPhoneNumber());
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(60, 564);
        contentStream.showText(resume.getPersonalInfo().getEmail());
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(60, 535);
        contentStream.showText(resume.getPersonalInfo().getLocation());
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(60, 505);
        contentStream.showText(resume.getPersonalInfo().getWebsite());
        contentStream.endText();

        contentStream.moveTo(300, 20);
        contentStream.lineTo(300, 610);
        contentStream.stroke();

        contentStream.moveTo(30, 285);
        contentStream.lineTo(300, 285);
        contentStream.stroke();

        contentStream.setNonStrokingColor(Color.BLACK);
        contentStream.setFont(font, 22);
        contentStream.setCharacterSpacing(7);

        contentStream.beginText();
        contentStream.newLineAtOffset(320, 591);
        contentStream.showText("PROFILE");
        contentStream.endText();

        contentStream.setNonStrokingColor(Color.GRAY);
        contentStream.setCharacterSpacing(0);
        contentStream.setFont(font, 14);

        String[] wrT;
        String s;
        wrT = WordUtils.wrap(resume.getPersonalInfo().getBio(), 65).split("\\r?\\n");

        for (int i=0; i< wrT.length; i++) {
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 10);
            contentStream.newLineAtOffset(320,564-i*15);
            s = wrT[i];
            contentStream.showText(s);
            contentStream.endText();
        }

        if (resume.getWorkExperience().size() > 0) {

            contentStream.setNonStrokingColor(Color.BLACK);
            contentStream.setFont(font, 22);
            contentStream.setCharacterSpacing(7);

            contentStream.beginText();
            contentStream.newLineAtOffset(320, 470);
            contentStream.showText("EXPERIENCE");
            contentStream.endText();

            contentStream.setNonStrokingColor(Color.GRAY);
            contentStream.setCharacterSpacing(0);

            int y_axis = 430;
            for (WorkExperience exp : resume.getWorkExperience()) {
                contentStream.setFont(font, 14);
                contentStream.setNonStrokingColor(Color.BLACK);
                contentStream.beginText();
                contentStream.newLineAtOffset(320, y_axis);
                contentStream.showText(exp.getJobTitle().toUpperCase());
                contentStream.endText();
                y_axis -= 20;

                contentStream.setNonStrokingColor(Color.GRAY);

                contentStream.beginText();
                contentStream.newLineAtOffset(320, y_axis);
                contentStream.showText(exp.getCompanyName());
                contentStream.endText();
                y_axis -= 20;

                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.beginText();
                contentStream.newLineAtOffset(320, y_axis);
                contentStream.showText(exp.getStartDate());
                contentStream.endText();
                y_axis -= 20;

                wrT = WordUtils.wrap(exp.getDescription(), 65).split("\\r?\\n");
                for (int i=0; i< wrT.length; i++) {
                    contentStream.beginText();
                    contentStream.setFont(PDType1Font.HELVETICA, 10);
                    contentStream.newLineAtOffset(320,y_axis-i*15);
                    s = wrT[i];
                    contentStream.showText(s);
                    contentStream.endText();
                }
                y_axis -= 70;
            }
        }

        if (resume.getSkill().size() > 0) {

            contentStream.setNonStrokingColor(Color.BLACK);
            contentStream.setFont(font, 22);
            contentStream.setCharacterSpacing(7);

            contentStream.beginText();
            contentStream.newLineAtOffset(30, 470);
            contentStream.showText("Skills".toUpperCase());
            contentStream.endText();

            contentStream.setNonStrokingColor(Color.GRAY);
            contentStream.setCharacterSpacing(0);
            contentStream.setFont(PDType1Font.HELVETICA, 10);


            int y_axis = 440;
            for (Skill skill : resume.getSkill()) {
                contentStream.beginText();
                contentStream.newLineAtOffset(35, y_axis);
                contentStream.showText("* " + skill.getSkillName());
                contentStream.endText();
                y_axis -= 20;
            }
        }

        if (resume.getEducation().size() > 0) {
            contentStream.setNonStrokingColor(Color.BLACK);
            contentStream.setFont(font, 22);
            contentStream.setCharacterSpacing(7);

            contentStream.beginText();
            contentStream.newLineAtOffset(30, 250);
            contentStream.showText("Education".toUpperCase());
            contentStream.endText();

            int y_axis = 210;
            for (Education education : resume.getEducation()) {
                contentStream.setNonStrokingColor(Color.BLACK);
                contentStream.setCharacterSpacing(0);
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.setRenderingMode(RenderingMode.FILL_STROKE);
                contentStream.setCharacterSpacing(2);


                contentStream.beginText();
                contentStream.newLineAtOffset(30, y_axis);
                contentStream.showText(education.getDegree().toUpperCase());
                contentStream.endText();
                y_axis -= 20;

                contentStream.setRenderingMode(RenderingMode.FILL);
                contentStream.setNonStrokingColor(Color.GRAY);
                contentStream.setCharacterSpacing(0);
                contentStream.setFont(PDType1Font.HELVETICA, 10);

                contentStream.beginText();
                contentStream.newLineAtOffset(30, y_axis);
                contentStream.showText(education.getSchool());
                contentStream.endText();
                y_axis -= 20;

                contentStream.setNonStrokingColor(Color.BLACK);

                contentStream.beginText();
                contentStream.newLineAtOffset(30, y_axis);
                contentStream.showText(education.getStartDate());
                contentStream.endText();
                y_axis -= 40;
            }
        }

        contentStream.close();

        document.save(resume.getPersonalInfo().getFullName().replaceAll("\\s+", "_") + "_resume.pdf");
        document.close();
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

    public List<Education> getEducation() {
        return education;
    }

    public List<Skill> getSkill() {
        return skills;
    }

    public List<WorkExperience> getWorkExperience() {
        return workExperience;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }
}
