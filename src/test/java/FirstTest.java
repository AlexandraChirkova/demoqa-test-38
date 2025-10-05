import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
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
        $("#dateOfBirthInput").scrollTo().click();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1988");
        $$(".react-datepicker__day")
                .findBy(text("12"))
                .click();
        $("#dateOfBirthInput").shouldHave(value("12 Aug 1988"));
        $("#subjectsInput").scrollTo().setValue("Maths").pressEnter();
        $(".subjects-auto-complete__multi-value__label")
                .shouldHave(text("Maths"));
        $("label[for='hobbies-checkbox-2']").click();
        $("#currentAddress").setValue("Almaty");


    }
}
