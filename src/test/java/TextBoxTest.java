import Pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxTest extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void fullTextBoxTest(){
        textBoxPage.openPage().
                setFullName("Arnold Schwarzenegger").
                setEmail("arnoldschwarzenegger@gmail.com").
                setCurrentAddress("Germany, Berlin").
                setPermanentAddress("France, Paris").
                submit();

        textBoxPage.checkResult("Name:","Arnold Schwarzenegger").
                checkResult("Email:", "arnoldschwarzenegger@gmail.com").
                checkResult("Current Address :","Germany, Berlin").
                checkResult("Permananet Address :", "France, Paris");
    }
}
