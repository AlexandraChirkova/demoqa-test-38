import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl="https://demoqa.com";
    }


    @Test
    void applicationFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alexandra");
        $("#lastName").setValue("Chirkova");
        $("#userEmail").setValue("alexandra,chirkova88@gmail.com");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("87051813123");
        $("#dateOfBirthInput").click();
        $("").setValue("").pressEnter();
        $("label[for='hobbies-checkbox-2']").click();

        $("#currentAddress").setValue("Almaty");


    }
}
