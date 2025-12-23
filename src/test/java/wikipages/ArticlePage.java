package wikipages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class ArticlePage {

    private SelenideElement articleHeader = $(id("pcs-edit-section-title-description"));

    public String getArticleHeader () {
        return articleHeader.getText();
    }
}
