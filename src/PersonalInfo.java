import java.util.Scanner;

public class PersonalInfo {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String profileImagePath;
    private String position;
    private String location;

    private String website;
    private String bio;

    public PersonalInfo() {
    }

    public PersonalInfo(String fullName, String email, String phoneNumber,
                        String profileImagePath, String position, String location, String website, String bio) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profileImagePath = profileImagePath;
        this.position = position;
        this.location = location;
        this.website = website;
        this.bio = bio;
    }

    public static PersonalInfo getInfo(Scanner scan) {
        System.out.print("Enter your full name: ");
        String fullName = scan.nextLine();

        System.out.print("Enter your position Ex: (Software Engineer, CEO, Web Developer): ");
        String position = scan.nextLine();

        System.out.print("Enter your region/location: ");
        String location = scan.nextLine();

        System.out.print("Enter your email address: ");
        String email = scan.nextLine();

        System.out.print("Enter your phone number: ");
        String phoneNumber = scan.nextLine();

        System.out.print("Enter your website: ");
        String website = scan.nextLine();

        System.out.println("Enter your bio: ");
        String bio = scan.nextLine();

        System.out.print("Enter the path of the image file: ");
        String profileImagePath = scan.nextLine();
        return new PersonalInfo(fullName, email, phoneNumber,
                profileImagePath, position, location, website, bio);
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getWebsite() {
        return website;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public String getBio() {
        return bio;
    }
}
