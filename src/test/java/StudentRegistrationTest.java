import Pages.StudentRegistrationPage;
import org.junit.jupiter.api.Test;

import java.io.File;

public class StudentRegistrationTest extends TestBase{

    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();
    File file = new File("src/test/resources/picture.jpg");



    @Test
    void successfulSearchTest() {
        studentRegistrationPage.openPage().
                setFirstName("Adil").
                setLastName("Pankirey").
                setEmail("pankireyadil@gmail.com").
                setGender("Male").
                setPhoneNumber("7089598475").
                setHobby("Sports").
                setHobby("Reading").setDateOfBirth("2","11","1999").
                setCurrentAddress("Kazakhstan, Astana").
                setSubject("English").
                setSubject("Commerce").
                uploadFile(file).
                setState("NCR").
                setCity("Delhi").
                submit();

        studentRegistrationPage.checkResult("Student Name", "Adil Pankirey").
                checkResult("Student Email","pankireyadil@gmail.com").
                checkResult("Gender","Male").
                checkResult("Mobile","7089598475").
                checkResult("Date of Birth", "2 December,1999")
                .checkResult("Subjects","English, Commerce").
                checkResult("Hobbies","Sports, Reading")
                .checkResult("Picture","picture.jpg")
                .checkResult("Address","Kazakhstan, Astana")
                .checkResult("State and City","NCR Delhi");
    }

    @Test
    void minSuccessfulTest(){
        studentRegistrationPage.openPage().
                setFirstName("Adil").
                setLastName("Pankirey").
                setGender("Male").
                setPhoneNumber("8708929456").
                setDateOfBirth("2","11","1999").
                submit();

        studentRegistrationPage.checkResult("Student Name","Adil Pankirey").
                checkResult("Gender","Male").
                checkResult("Mobile","8708929456").
                checkResult("Date of Birth", "2 December,1999");
    }

    @Test
    void emptyFirstNameTest(){
        studentRegistrationPage.openPage().
                setLastName("Pankirey").
                setGender("Male").
                setPhoneNumber("8708929456").
                setDateOfBirth("2","11","1999").
                submit();

        studentRegistrationPage.checkFormIsNotDisplayed();
    }
    @Test
    void emptyGenderTest(){
        studentRegistrationPage.openPage().
                setFirstName("Adil").
                setLastName("Pankirey").
                setPhoneNumber("8708929456").
                setDateOfBirth("2","11","1999").
                submit();

        studentRegistrationPage.checkFormIsNotDisplayed();
    }
}
