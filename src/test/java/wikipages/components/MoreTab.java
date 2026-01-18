package wikipages.components;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import wikipages.SettingsScreen;

import static com.codeborne.selenide.Selenide.$;

public class MoreTab {

    private final SelenideElement settingsTab = $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_settings_container"));

    public SettingsScreen clickOnSettings() {
        settingsTab.click();
        return new SettingsScreen();
    }
}
