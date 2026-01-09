package wikipages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Dimension;
import java.util.Map;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SettingsPage {

    private final SelenideElement settingsTab = $(AppiumBy.xpath("//android.widget.TextView[@text='Settings']")),
    showLinkPreviewsSwitch = $(AppiumBy.xpath("(//android.widget.Switch[@resource-id='org.wikipedia.alpha:id/switchWidget'])[1]")),
    preferOfflineSwitch = $(AppiumBy.xpath("(//android.widget.Switch[@resource-id='org.wikipedia.alpha:id/switchWidget'])[3]"));

    public String getSettingsTabHeader() {
        return settingsTab.getText();
    }

    public boolean checkShowPreviewIsTrue() {
        return showLinkPreviewsSwitch.is(checked);
    }

    public boolean checkPreferOfflineIsFalse() {
        return !preferOfflineSwitch.is(checked);
    }

    public SettingsPage scrollToPreferOffline() {
        Dimension size = getWebDriver().manage().window().getSize();

        // Используем scrollGesture
        for (int i = 0; i < 3; i++) {
            executeJavaScript("mobile: scrollGesture", Map.of(
                    "left", 100,
                    "top", 100,
                    "width", size.width - 200,
                    "height", size.height - 200,
                    "direction", "down",
                    "percent", 2.0  // 200% - большой скролл
            ));

            sleep(800);
        }

        return this;
    }
}

