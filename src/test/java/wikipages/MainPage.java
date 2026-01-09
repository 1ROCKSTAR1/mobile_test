package wikipages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {

    private final SelenideElement searchField = $(accessibilityId("Search Wikipedia")),
    realSearchField = $(id("org.wikipedia.alpha:id/search_src_text")),
    titleArticle = $(id("pcs-edit-section-title-description")),
    savedTab = $(id("org.wikipedia.alpha:id/nav_tab_reading_lists")),
    moreTab = $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_more"));

    private final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    public MainPage clickOnFakeSearchField() {
        searchField.click();
        return this;
    }

    public MainPage sendSearchPhraseInRealSearchField(String s) {
        realSearchField.sendKeys(s);
        return this;
    }

    public boolean checkAllResultsNotEmpty() {
        try {
            searchResults.shouldHave(CollectionCondition.allMatch(
                    "Все элементы должны содержать непустой текст",
                    element -> {
                        String text = element.getText();
                        return text != null && !text.trim().isEmpty();
                    }
            ));
            return true;
        } catch (AssertionError e) {
            System.err.println("Найдены пустые элементы: " + e.getMessage());
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

    public SavedTab clickOnSavedTab() {
        savedTab.click();
        return new SavedTab();
    }

    public MoreTab clickOnMoreTab() {
        moreTab.click();
        return new MoreTab();
    }
}


