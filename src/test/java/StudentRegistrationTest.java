import Pages.StudentRegistrationPage;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static utils.RandomUtils.*;

public class StudentRegistrationTest extends TestBase{

    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    String firstName = getRandomFirstName();
    String lastName = getRandomLastName();
    String email = getRandomEmail();
    String streetAddress = getRandomAddress();
    String gender = getGender();
    String phoneNumber = getRandomPhoneNumber();
    String subject1 = getRandomSubjects();
    String subject2 = getRandomSubjects(subject1);
    String subject3 = getRandomSubjects(subject1, subject2);
    String state = getRandomState();
    String city = getRandomCity(state);
    String hobby = getRandomHobby();
    Date birthday = getRandomDate();
    String day = getRandomDayOfBirthday(birthday);
    String month = getRandomMonthOfBirthday(birthday);
    String year = getRandomYearOfBirthday(birthday);
    String picture = getPRandomPicture();
    @Test
    void successfulSearchTest() {

        studentRegistrationPage.openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setEmail(email).
                setGender(gender).
                setPhoneNumber(phoneNumber).
                setHobby(hobby).
                setDateOfBirth(day,month,year).
                setCurrentAddress(streetAddress).
                setSubject(subject1).
                setSubject(subject2).
                setSubject(subject3).
                uploadFile(picture).
                setState(state).
                setCity(city).
                submit();

        studentRegistrationPage.checkResult("Student Name", firstName +' '+lastName).
                checkResult("Student Email",email).
                checkResult("Gender",gender).
                checkResult("Mobile",phoneNumber).
                checkResult("Date of Birth", day+ " "+month+","+ year).
                checkResult("Subjects",subject1).
                checkResult("Subjects",subject2).
                checkResult("Subjects",subject3).
                checkResult("Hobbies",hobby)
                .checkResult("Picture",picture)
                .checkResult("Address",streetAddress)
                .checkResult("State and City",state +" " + city);
    }

    @Test
    void minSuccessfulTest(){
        studentRegistrationPage.openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setGender(gender).
                setPhoneNumber(phoneNumber).
                setDateOfBirth(day,month,year).
                submit();

        studentRegistrationPage.checkResult("Student Name",firstName + ' ' + lastName).
                checkResult("Gender",gender).
                checkResult("Mobile",phoneNumber).
                checkResult("Date of Birth", day+ " "+month+","+ year);
    }

    @Test
    void emptyFirstNameTest(){
        studentRegistrationPage.openPage().
                setLastName(firstName).
                setGender(gender).
                setPhoneNumber(phoneNumber).
                setDateOfBirth(day,month,year).
                submit();

        studentRegistrationPage.checkFormIsNotDisplayed();
    }
    @Test
    void emptyGenderTest(){
        studentRegistrationPage.openPage().
                setFirstName(firstName).
                setLastName(lastName).
                setPhoneNumber(phoneNumber).
                setDateOfBirth(day,month,year).
                submit();

        studentRegistrationPage.checkFormIsNotDisplayed();
    }
}
