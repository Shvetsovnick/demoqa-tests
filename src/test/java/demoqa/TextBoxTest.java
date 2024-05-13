package demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1280";
        Configuration.baseUrl = "https://demoqa.com";

    }

    @Test
    void fillFormTest(){
        open("/text-box");
        $("h1.text-center").shouldHave(text("Text Box"));
        $("#userName").setValue("User Name");
        $("#userEmail").setValue("userEmail@mail.co");
        $("#currentAddress").setValue("2233 Travis Line, San Angelo, Alaska");
        $("#permanentAddress").setValue("Same as current");
        $("#submit").click();
        $("#output").shouldBe(visible);
        $("#output #name").shouldHave(text("User Name"));
        $("#output #email").shouldHave(text("userEmail@mail.co"));

    }
}
