package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import config.TestConfig;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class EmulatorDriver implements WebDriverProvider {

    private static final TestConfig config =
            ConfigFactory.create(TestConfig.class, System.getProperties());

    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        // Базовые настройки
        options.setCapability("platformName", "Android");
        options.setCapability("appium:automationName", "UiAutomator2");

        // Локальные настройки
        options.setCapability("appium:appPackage", config.appPackage());
        options.setCapability("appium:appActivity", config.appActivity());
        options.setCapability("appium:deviceName", config.deviceName());
        options.setCapability("appium:platformVersion", config.platformVersion());
        options.setCapability("appium:autoGrantPermissions", true);
        options.setCapability("appium:noReset", false);
        options.setCapability("appium:fullReset", false);

        // Если есть локальный APK файл
        File app = new File("src/test/resources/app-alpha-universal-release.apk");
        if (app.exists()) {
            options.setCapability("appium:app", app.getAbsolutePath());
        }

        try {
            return new AndroidDriver(new URL(config.remoteUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
