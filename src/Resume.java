import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.commons.lang3.text.WordUtils;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Resume {
    private PersonalInfo personalInfo;
    private List<Education> education;
    private final ArrayList<WorkExperience> workExperience = new ArrayList<WorkExperience>();
    private List<Skill> skills;

    public static void createResume(Resume resume) throws IOException {
        final int WIDTH = 120;
        final int HEIGHT = 120;

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

//        contentStream.moveTo(50, 505);
//        contentStream.lineTo(50, 600);
//        contentStream.stroke();

        contentStream.setNonStrokingColor(Color.BLACK);
        contentStream.setFont(font, 22);
        contentStream.setCharacterSpacing(7);

        contentStream.beginText();
        contentStream.newLineAtOffset(200, 450);
        contentStream.showText("PROFILE");
        contentStream.endText();

        contentStream.setNonStrokingColor(Color.GRAY);
        contentStream.setCharacterSpacing(0);
        contentStream.setFont(font, 14);

        contentStream.beginText();
        contentStream.newLineAtOffset(200, 450);
        contentStream.showText(resume.getPersonalInfo().getBio());
        contentStream.endText();

        String[] wrT;
        String s;
        String text = resume.getPersonalInfo().getBio();

        wrT = WordUtils.uncapitalize()
        wrT = WordUtils.wrap(text, 100).split("\\r?\\n");

        for (int i=0; i< wrT.length; i++) {
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 10);
            contentStream.newLineAtOffset(50,600-i*15);
            s = wrT[i];
            contentStream.showText(s);
            contentStream.endText();
        }


        if (resume.getWorkExperience().size() > 0) {

            contentStream.setNonStrokingColor(Color.BLACK);
            contentStream.setFont(font, 22);
            contentStream.setCharacterSpacing(7);

            contentStream.beginText();
            contentStream.newLineAtOffset(30, 450);
            contentStream.showText("EXPERIENCE");
            contentStream.endText();

            contentStream.setNonStrokingColor(Color.GRAY);
            contentStream.setCharacterSpacing(0);

            int y_axis = 420;
            for (WorkExperience exp : resume.getWorkExperience()) {
                contentStream.setFont(font, 14);
                contentStream.setNonStrokingColor(Color.BLACK);
                contentStream.beginText();
                contentStream.newLineAtOffset(30, y_axis);
                contentStream.showText(exp.getJobTitle().toUpperCase());
                contentStream.endText();
                y_axis -= 20;


                contentStream.setNonStrokingColor(Color.GRAY);

                contentStream.beginText();
                contentStream.newLineAtOffset(30, y_axis);
                contentStream.showText(exp.getCompanyName());
                contentStream.endText();
                y_axis -= 20;


                contentStream.beginText();
                contentStream.newLineAtOffset(30, y_axis);
                contentStream.showText(exp.getDescription());
                contentStream.endText();
                y_axis -= 20;
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
