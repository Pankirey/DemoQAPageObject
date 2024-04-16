package Pages;

import Pages.components.CalendarComponent;
import Pages.components.ResultComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponent resultComponent= new ResultComponent();

    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            currentAddressInput =  $("#currentAddress"),
            subjectsInput = $("#subjectsInput"),
            fileInput = $("#uploadPicture"),
            stateInput = $("#state"),
            cityInput =  $("#city"),
            submitButton = $("#submit");



    public StudentRegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public StudentRegistrationPage setFirstName(String name){
        firstNameInput.setValue(name);
        return this;
    }
    public StudentRegistrationPage setLastName(String lastName){
        lastNameInput.setValue(lastName);
        return this;
    }
    public StudentRegistrationPage setEmail(String email){
        emailInput.setValue(email);
        return this;
    }
    public StudentRegistrationPage setGender(String gender){
        genderWrapper.$(byText(gender)).click();
        return this;
    }
    public StudentRegistrationPage setPhoneNumber(String phoneNumber){
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    public StudentRegistrationPage setHobby(String hobby){
        hobbiesWrapper.$(byText(hobby)).click();
        return this;
    }

    public StudentRegistrationPage setDateOfBirth(String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDate(day,month,year);
        return this;
    }
    public StudentRegistrationPage setCurrentAddress(String address){
        currentAddressInput.setValue(address);
        return this;
    }
    public StudentRegistrationPage setSubject(String subject){
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }
    public StudentRegistrationPage uploadFile(String file){
        fileInput.uploadFromClasspath(file);
        return this;
    }
    public StudentRegistrationPage setState(String state){
        stateInput.click();
        $(byText(state)).click();
        return this;
    }
    public StudentRegistrationPage setCity(String city){
        cityInput.click();
        $(byText(city)).click();
        return this;
    }
    public StudentRegistrationPage submit(){
        submitButton.click();
        return this;
    }
    public StudentRegistrationPage checkResult(String key, String value){
        resultComponent.checkResultForm(key,value);
        return this;
    }
    public StudentRegistrationPage checkFormIsNotDisplayed(){
        resultComponent.resultFormDoesNotAppear();
        return this;
    }
}
