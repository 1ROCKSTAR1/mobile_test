package wikipages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;

public class ArticleScreen {

    private SelenideElement articleHeader = $(className("android.widget.TextView"));

    public String getArticleHeader () {
        return articleHeader.getText();
    }
}
