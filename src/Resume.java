import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Resume {
    private PersonalInfo personalInfo;
    private List<Education> education;
    private ArrayList<WorkExperience> workExperience = new ArrayList<WorkExperience>();
    private List<Skill> skills;


    public static void displayImage(Resume resume, PDDocument document, PDPageContentStream contentStream, int posX,
                                    int posY, int width, int height) throws IOException {
        PDImageXObject image = PDImageXObject.createFromFile(resume.getPersonalInfo().getProfileImagePath(),
                document);
        contentStream.drawImage(image, posX, posY, width, height);
        contentStream.close();
    }

    public static void createResume(Resume resume) throws IOException {
        final int WIDTH = 120;
        final int HEIGHT = 120;

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        PDFont font = PDType1Font.HELVETICA_BOLD;

        contentStream.setFont(font, 18);
        contentStream.setNonStrokingColor(Color.DARK_GRAY);

        contentStream.drawImage(PDImageXObject.createFromFile("assets/banner.png",
                document), 0, 600, 700, 160);

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 600);
        contentStream.showText("Name: " + resume.getPersonalInfo().getFullName());
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 580);
        contentStream.showText("Email: " + resume.getPersonalInfo().getEmail());
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 560);
        contentStream.showText("Phone: " + resume.getPersonalInfo().getPhoneNumber());
        contentStream.endText();

        if (resume.getWorkExperience().size() > 0) {
            int y_axis = 630;
            contentStream.setNonStrokingColor(Color.BLACK);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 650);
            contentStream.showText("Work Experience");
            contentStream.endText();

            for (WorkExperience exp : resume.getWorkExperience()) {
                contentStream.setFont(font, 14);
                contentStream.beginText();
                contentStream.newLineAtOffset(50, y_axis);
                contentStream.showText("Title: " + exp.getJobTitle());
                contentStream.endText();
                y_axis -= 20;


                contentStream.beginText();
                contentStream.newLineAtOffset(50, y_axis);
                contentStream.showText("Company: " + exp.getCompanyName());
                contentStream.endText();
                y_axis -= 20;


                contentStream.beginText();
                contentStream.newLineAtOffset(50, y_axis);
                contentStream.showText("Description: " + exp.getDescription());
                contentStream.endText();
                y_axis -= 20;
            }
        }



        contentStream.drawImage(PDImageXObject.createFromFile(resume.getPersonalInfo().getProfileImagePath(),
                document), 450, 630, 120, 120);
        contentStream.close();

        document.save(resume.getPersonalInfo().getFullName().replaceAll("\\s+", "") + "_resume.pdf");
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
