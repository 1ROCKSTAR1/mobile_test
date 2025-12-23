package wikipages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {

    private final SelenideElement searchField = $(accessibilityId("Search Wikipedia")),
    realSearchField = $(id("org.wikipedia.alpha:id/search_src_text")),
    titleArticle = $(id("pcs-edit-section-title-description"));

    private final ElementsCollection searchResults = $$(id("pcs-edit-section-title-description"));

    public MainPage clickOnFakeSearchField() {
        searchField.click();
        return this;
    }

    public MainPage sendSearchPhraseInRealSearchField(String s) {
        realSearchField.sendKeys(s);
        return this;
    }

    public boolean checkStatusTheFinalString(String s) {
        try {
            searchResults.shouldHave(CollectionCondition.allMatch(
                    "Все элементы содержат строку: " + s,
                    a -> a.getText().toLowerCase().contains(s)
            ));
            return true;
        } catch (AssertionError e) {
            return false;
        }
    }

    public String checkArticle() {
        return titleArticle.getText();
    }

    public MainPage clickOnFirstItem() {
        searchResults
                .get(0)
                .click();

        return this;
    }
}


