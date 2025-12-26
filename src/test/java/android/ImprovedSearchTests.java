package android;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wikipages.ArticlePage;
import wikipages.MainPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;


public class ImprovedSearchTests extends BaseAndroidTest {

    MainPage mainPage = new MainPage();
    ArticlePage articlePage = new ArticlePage();

    @Test
    @DisplayName("Первый мобильный тест на мобилку с appium+selenide")
    void successfulSearchTestComplete() {

        $(accessibilityId("Search Wikipedia")).click();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");

        $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
    }

    @Test
    @DisplayName("Мобильный тест на мобилку с appium+selenide (НЕГАТИВНЫЙ)")
    void successfulSearchTestCompleteNegative() {

        $(accessibilityId("Search Wikipedia")).click();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(";lkj;lkhjljkgyy");

        $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
    }

    @Test
    @DisplayName("Мобильный тест на мобилку с appium+selenide (поиск статьи)")
    void successfulSearchTestArticle() {

        $(accessibilityId("Search Wikipedia")).click();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Formula-1");

        $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                .get(0)
                .click();

        $(id("pcs-edit-section-title-description")).shouldHave(text("Competition"));
    }

    @Test
    @DisplayName("Мобильный тест на POM. Проверка что результат не пустой")
    void searchEmptyTest() {

        boolean actualResult = mainPage
                .clickOnFakeSearchField()
                .sendSearchPhraseInRealSearchField("NASCAR")
                .checkAllResultsNotEmpty();

        Assertions.assertTrue(actualResult);
    }

    @Test
    @DisplayName("Мобильный тест на POM. Проверка что статья содержит искомое значение")
    void searchArticleTest() {

        mainPage
                .clickOnFakeSearchField()
                .sendSearchPhraseInRealSearchField("NASCAR")
                .clickOnFirstItem();

        String actualArticleHeader = articlePage
                .getArticleHeader();

        Assertions.assertEquals("competition", actualArticleHeader);
    }
}