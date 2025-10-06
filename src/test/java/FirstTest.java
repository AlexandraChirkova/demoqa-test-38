import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        $x("//div[contains(@id,'react-select') and text()='NCR']").click();
        $("#city").click();
        $x("//div[contains(@id,'react-select') and text()='Delhi']").click();
        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $(".modal-content").$(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']/following-sibling::td").shouldHave(text("Alexandra Chirkova"));
        $x("//td[text()='Student Email']/following-sibling::td").shouldHave(text("alexandra.chirkova88@gmail.com"));
        $x("//td[text()='Gender']/following-sibling::td").shouldHave(text("Female"));
        $x("//td[text()='Mobile']/following-sibling::td").shouldHave(text("8705181312"));
        $x("//td[text()='Date of Birth']/following-sibling::td").shouldHave(text("12 August,1988"));
        $x("//td[text()='Subjects']/following-sibling::td").shouldHave(text("Maths"));
        $x("//td[text()='Hobbies']/following-sibling::td").shouldHave(text("Reading"));
        $x("//td[text()='Picture']/following-sibling::td").shouldHave(text("img1.jpeg"));
        $x("//td[text()='Address']/following-sibling::td").shouldHave(text("Almaty"));
        $x("//td[text()='State and City']/following-sibling::td").shouldHave(text("NCR Delhi"));
    }

}
