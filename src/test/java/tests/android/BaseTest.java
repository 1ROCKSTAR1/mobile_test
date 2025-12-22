package tests.android;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserStackAndroidDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = BrowserStackAndroidDriver.class.getName();
        Configuration.browserSize = null; // обязательный костыль №1
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open(); // обязательный костыль №2
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        closeWebDriver();
    }
}
