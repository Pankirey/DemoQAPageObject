import Pages.StudentRegistrationPage;
import org.junit.jupiter.api.Test;

import java.io.File;

import static utils.RandomUtils.*;

public class StudentRegistrationTest extends TestBase{

    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    File file = new File("src/test/resources/picture.jpg");

    String firstName = getRandomFirstName();
    String lastName = getRandomLastName();
    String email = getRandomEmail();
    String streetAddress = getRandomAddress();
    String gender = getGender();

    @Test
    void successfulSearchTest() {

        studentRegistrationPage.openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setEmail(email).
                setGender(gender).
                setPhoneNumber("7089598475").
                setHobby("Sports").
                setHobby("Reading").
                setDateOfBirth("02","11","1999").
                setCurrentAddress(streetAddress).
                setSubject("English").
                setSubject("Commerce").
                uploadFile(file).
                setState("NCR").
                setCity("Delhi").
                submit();

        studentRegistrationPage.checkResult("Student Name", firstName +' '+lastName).
                checkResult("Student Email",email).
                checkResult("Gender",gender).
                checkResult("Mobile","7089598475").
                checkResult("Date of Birth", "2 December,1999")
                .checkResult("Subjects","English, Commerce").
                checkResult("Hobbies","Sports, Reading")
                .checkResult("Picture","picture.jpg")
                .checkResult("Address",streetAddress)
                .checkResult("State and City","NCR Delhi");
    }

    @Test
    void minSuccessfulTest(){
        studentRegistrationPage.openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setGender("Male").
                setPhoneNumber("8708929456").
                setDateOfBirth("02","11","1999").
                submit();

        studentRegistrationPage.checkResult("Student Name",firstName + ' ' + lastName).
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
