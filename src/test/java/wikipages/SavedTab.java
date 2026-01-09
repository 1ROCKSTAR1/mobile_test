package wikipages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class SavedTab {

    final SelenideElement savedTab = $(AppiumBy.xpath("//android.widget.TextView[@text='Saved'][1]"));

    public String getSavedTabHeader() {
        return savedTab.getText();
    }
}
