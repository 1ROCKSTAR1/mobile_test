package wikipages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class ArticlePage {

    private SelenideElement articleHeader = $(className("android.widget.TextView"));

    public String getArticleHeader () {
        return articleHeader.getText();
    }
}
