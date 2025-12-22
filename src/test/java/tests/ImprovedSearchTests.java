package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;


public class ImprovedSearchTests extends BaseTest {

    @Test
    @DisplayName("Первый мобильный тест на мобилку с appium+selenide")
    void successfulSearchTestComplete() {

        $(accessibilityId("Search Wikipedia")).click();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");

        $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
    }

    @Test
    @DisplayName("Первый мобильный тест на мобилку с appium+selenide (НЕГАТИВНЫЙ)")
    void successfulSearchTestCompleteNegative() {

        $(accessibilityId("Search Wikipedia")).click();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(";lkj;lkhjljkgyy");

        $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
    }
}
