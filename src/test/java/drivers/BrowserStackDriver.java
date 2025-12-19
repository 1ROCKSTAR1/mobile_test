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

public class BrowserStackDriver implements WebDriverProvider {

    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", "alexv_gQHKd7");
        bstackOptions.put("accessKey", "B1ZjyFYFzuFN4KBRChiC");
        bstackOptions.put("deviceName", "Samsung Galaxy S22 Ultra");
        bstackOptions.put("osVersion", "12.0");
        bstackOptions.put("projectName", "First Java Project");
        bstackOptions.put("buildName", "browserstack-build-1");
        bstackOptions.put("sessionName", "first_test");

        // Ключевые capabilities БЕЗ префикса appium:
        options.setCapability("platformName", "Android");
        options.setCapability("app", "bs://sample.app"); // Оставляем демо-приложение

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
