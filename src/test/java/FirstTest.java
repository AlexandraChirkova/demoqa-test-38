import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

    @BeforeAll
    static void setupConfig(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl="https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void applicationFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alexandra");
        $("#lastName").setValue("Chirkova");
        $("#userEmail").setValue("alexandra.chirkova88@gmail.com");
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
        $("#uploadPicture").uploadFromClasspath("images/img1.jpeg");
        $("#currentAddress").setValue("Almaty");
        $("#state").click();
        $("#state input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#city input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $(".modal-content").$(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Alexandra Chirkova"));
        $(".modal-body").shouldHave(text("alexandra.chirkova88@gmail.com"));
        $(".modal-body").shouldHave(text("Female"));
        $(".modal-body").shouldHave(text("8705181312"));
        $(".modal-body").shouldHave(text("12 August,1988"));
        $(".modal-body").shouldHave(text("Maths"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave( text("img1.jpeg"));
        $(".modal-body").shouldHave(text("Almaty"));
        $(".modal-body").shouldHave(text("NCR Delhi"));
    }

}
