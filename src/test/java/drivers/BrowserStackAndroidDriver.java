package drivers;

import config.TestConfig;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackAndroidDriver implements WebDriverProvider {

    private static final TestConfig config =
            ConfigFactory.create(TestConfig.class, System.getProperties());
    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        System.out.println("=== BROWSERSTACK CONFIG ===");
        System.out.println("User: " + config.browserstackId());
        System.out.println("Key: " + config.browserstackKey());
        System.out.println("Device: " + config.browserstackDevice());
        System.out.println("OS Version: " + config.browserstackOsVersion());
        System.out.println("App: " + config.app());
        System.out.println("==========================");

        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", config.browserstackId());
        bstackOptions.put("accessKey", config.browserstackKey());
        bstackOptions.put("deviceName", config.browserstackDevice());
        bstackOptions.put("platformVersion", config.browserstackOsVersion());  // Исправлено с osVersion на platformVersion
        bstackOptions.put("projectName", "First Java Project");
        bstackOptions.put("buildName", "browserstack-build-1");
        bstackOptions.put("sessionName", "first_test");

        // Новые обязательные параметры для BrowserStack
        bstackOptions.put("appiumVersion", "2.0.0");

        // ВАЖНО: Для BrowserStack используем только W3C capabilities без префикса 'appium:'
        // Основные capabilities (W3C стандарт)
        options.setCapability("platformName", "android");
        options.setCapability("appium:automationName", "uiautomator2");
        options.setCapability("appium:app", config.app());

        // BrowserStack options
        options.setCapability("bstack:options", bstackOptions);

        // Дополнительные настройки для стабильности
        options.setCapability("appium:noReset", false);
        options.setCapability("appium:fullReset", false);
        options.setCapability("appium:autoGrantPermissions", true);
        options.setCapability("appium:newCommandTimeout", 300);

        try {
            URL url = new URL("https://hub.browserstack.com/wd/hub");
            System.out.println("Connecting to: " + url);
            return new AndroidDriver(url, options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid BrowserStack URL", e);
        } catch (Exception e) {
            System.err.println("Error creating BrowserStack session: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
