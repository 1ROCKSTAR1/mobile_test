package android;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserStackAndroidDriver;
import helpers.Attach;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BaseAndroidTest {

    private static final TestConfig config =
            ConfigFactory.create(TestConfig.class, System.getProperties());

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
        // Обновленный обработчик
        try {
            // Проверяем Skip (быстрая проверка)
            if ($(AppiumBy.xpath("//*[@text='Skip']")).isDisplayed()) {
                $(AppiumBy.xpath("//*[@text='Skip']")).click();
                return;
            }

            // Проверяем Learn more (быстрая проверка)
            if ($(AppiumBy.xpath("//*[@text='Get started']")).isDisplayed()) {
                $(AppiumBy.xpath("//*[@text='Get started']")).click();
                // Ждем и нажимаем Skip если появился
                $(AppiumBy.xpath("//*[@text='Skip']"))
                        .shouldBe(visible, Duration.ofSeconds(8))
                        .click();
                return;
            }
        } catch (Exception e) {
            // Ничего не делаем - onboarding не обнаружен
        }
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last screenshot");
        closeWebDriver();
    }
}
