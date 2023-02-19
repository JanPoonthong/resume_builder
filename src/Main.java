import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String fullName = scan.nextLine();

        System.out.print("Enter your email address: ");
        String email = scan.nextLine();

        System.out.print("Enter your phone number: ");
        String phoneNumber = scan.nextLine();

        System.out.print("Enter your job title: ");
        String jobTitle = scan.nextLine();

        System.out.print("Enter your company name: ");
        String company = scan.nextLine();

        System.out.print("Enter your job description: ");
        String jobDescription = scan.nextLine();

        System.out.print("Enter the path of the image file: ");
        String profileImagePath = scan.nextLine();

        PersonalInfo user = new PersonalInfo(fullName, email, phoneNumber, profileImagePath);

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        PDFont font = PDType1Font.HELVETICA_BOLD;

        contentStream.setFont(font, 18);
        contentStream.setNonStrokingColor(Color.DARK_GRAY);
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 750);
        contentStream.showText("Name: " + fullName);
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 720);
        contentStream.showText("Email: " + email);
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 690);
        contentStream.showText("Phone: " + phoneNumber);
        contentStream.endText();

        contentStream.setNonStrokingColor(Color.BLACK);
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 650);
        contentStream.showText("Work Experience");
        contentStream.endText();

        contentStream.setFont(font, 14);
        contentStream.beginText();
        contentStream.newLineAtOffset(50, 630);
        contentStream.showText("Title: " + jobTitle);
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 610);

        contentStream.showText("Company: " + company);
        contentStream.endText();

        contentStream.beginText();
        contentStream.newLineAtOffset(50, 590);
        contentStream.showText("Description: " + jobDescription);
        contentStream.endText();

        PDImageXObject image = PDImageXObject.createFromFile(profileImagePath, document);
        contentStream.drawImage(image, 500, 500, 120, 120);

        contentStream.close();

        document.save(fullName + " Resume.pdf");
        document.close();
    }
}
