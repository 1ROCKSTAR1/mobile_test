package emulator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wikipages.MainPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class Tests extends BaseEmulatorTest {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Первый мобильный тест на мобилку с appium+selenide. Проверка что результат не пустой")
    void successfulSearchTestComplete() {
        back();
        $(accessibilityId("Search Wikipedia")).click();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");

        $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
    }

    @Test
    @DisplayName("Мобильный тест на POM. Проверка что результат не пустой")
    void searchEmptyTest() {
        back();
        boolean actualResult = mainPage
                .clickOnFakeSearchField()
                .sendSearchPhraseInRealSearchField("NASCAR")
                .checkAllResultsNotEmpty();

        Assertions.assertTrue(actualResult);
    }
}
