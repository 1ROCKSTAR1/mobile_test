package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.getProperty;

public class BrowserStackIosDriver implements WebDriverProvider {

    private static final String BROWSERSTACK_DEVICE = getProperty("browserstack.device", "iPhone 14");
    private static final String BROWSERSTACK_OS_VERSION = getProperty("browserstack.os_version", "16");

    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        XCUITestOptions options = new XCUITestOptions();

        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", "alexv_gQHKd7");
        bstackOptions.put("accessKey", "B1ZjyFYFzuFN4KBRChiC");
        bstackOptions.put("deviceName", BROWSERSTACK_DEVICE);
        bstackOptions.put("osVersion", BROWSERSTACK_OS_VERSION);
        bstackOptions.put("projectName", "First Java Project");
        bstackOptions.put("buildName", "browserstack-build-1");
        bstackOptions.put("sessionName", "first_ios_test");

        // Ключевые capabilities для iOS
        options.setCapability("platformName", "iOS");
        options.setCapability("appium:automationName", "XCUITest");
        // Укажите ваш App ID для iOS. Это может быть:
        // 1. ID загруженного в BrowserStack приложения (например, "bs://abc123...")
        // 2. Путь к файлу .app (для локального Appium)
        options.setCapability("app", "YOUR_IOS_APP_ID_HERE");

        // Присоединяем настройки BrowserStack
        options.setCapability("bstack:options", bstackOptions);

        try {
            return new IOSDriver(new URL("https://hub.browserstack.com/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
