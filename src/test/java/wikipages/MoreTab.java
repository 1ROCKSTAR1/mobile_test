package wikipages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class MoreTab {

    private final SelenideElement settingsTab = $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_settings_container"));

    public SettingsPage clickOnSettings() {
        settingsTab.click();
        return new SettingsPage();
    }
}
