package com.iliagubarev.proof.selenide;

import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class SampleTest {

    @Before
    public void setBrowser() {
        Configuration.baseUrl = "http://yandex.ru";
        Configuration.browser = "chrome";
    }

    @Test
    public void runsSampleTest() {
        open("/images");
        $(By.name("user.name")).setValue("johny");
        $("#submit").click();
        $(".loading_progress").should(disappear); // Waits until element disappears
        $("#username").shouldHave(text("Hello, Johny!"));
    }
}
