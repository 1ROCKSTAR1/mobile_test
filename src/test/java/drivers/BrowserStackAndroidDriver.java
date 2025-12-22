package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.getProperty;

public class BrowserStackAndroidDriver implements WebDriverProvider {

    private static final String BROWSERSTACK_DEVICE = getProperty("browserstack.device", "Samsung Galaxy S22 Ultra");
    private static final String BROWSERSTACK_OS_VERSION = getProperty("browserstack.os_version", "12.0");

    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", "alexv_gQHKd7");
        bstackOptions.put("accessKey", "B1ZjyFYFzuFN4KBRChiC");
        bstackOptions.put("deviceName", BROWSERSTACK_DEVICE);
        bstackOptions.put("osVersion", BROWSERSTACK_OS_VERSION);
        bstackOptions.put("projectName", "First Java Project");
        bstackOptions.put("buildName", "browserstack-build-1");
        bstackOptions.put("sessionName", "first_test");

        // Ключевые capabilities БЕЗ префикса appium:
        options.setCapability("platformName", "Android");
        options.setCapability("app", "bs://sample.app");

        // Appium-специфичные настройки
        options.setCapability("appium:automationName", "UiAutomator2");

        // Присоединяем настройки BrowserStack
        options.setCapability("bstack:options", bstackOptions);

        // ========== 2. ИНИЦИАЛИЗАЦИЯ ДРАЙВЕРА ==========
        try {
            return new AndroidDriver(new URL("https://hub.browserstack.com/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
