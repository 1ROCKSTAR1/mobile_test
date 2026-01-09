package emulator;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.TestConfig;
import drivers.EmulatorDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class BaseEmulatorTest {

    private static final TestConfig config =
            ConfigFactory.create(TestConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = EmulatorDriver.class.getName();
        Configuration.browserSize = null; // обязательный костыль №1
        Configuration.timeout = 10000;
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
