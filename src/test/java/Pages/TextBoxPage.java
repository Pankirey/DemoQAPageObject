package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private final SelenideElement fullNameInput = $("#userName"),
    emailInput = $("#userEmail"),
    currentAddressInput = $("#currentAddress"),
    permanentAddressInput = $("#permanentAddress"),
    submitButton = $("#submit"),
    resultForm = $("#output");

    public TextBoxPage openPage(){
        open("/text-box");
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('footer').remove()");
        return this;
    }
    public TextBoxPage setFullName(String fullName){
        fullNameInput.setValue(fullName);
        return this;
    }
    public TextBoxPage setEmail(String email){
        emailInput.setValue(email);
        return this;
    }
    public TextBoxPage setCurrentAddress(String currentAddress){
        currentAddressInput.setValue(currentAddress);
        return this;
    }
    public TextBoxPage setPermanentAddress(String permanentAddress){
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }
    public TextBoxPage submit(){
        submitButton.click();
        return this;
    }
    public TextBoxPage checkResult(String key, String value){
        resultForm.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }


}
