package emulator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wikipages.MainPage;

import static com.codeborne.selenide.Selenide.*;

public class Tests extends BaseEmulatorTest {

    MainPage mainPage = new MainPage();

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

    @Test
    @DisplayName("Мобильный тест на POM. Проверка хэдера вкладки 'saved' ")
    void savedTabTestPOM() {
        back();
        String expectedHeader = mainPage
                .clickOnSavedTab()
                .getSavedTabHeader();

        Assertions.assertEquals("Saved", expectedHeader);
    }

    @Test
    @DisplayName("Мобильный тест на POM. Проверка хэдера вкладки 'settings' ")
    void savedSettingsTestPOM() {
        back();
        String expectedHeader = mainPage
                .clickOnMoreTab()
                .clickOnSettings()
                .getSettingsTabHeader();

        Assertions.assertEquals("Settings", expectedHeader);
    }

    @Test
    @DisplayName("Мобильный тест на POM. Проверка switch 'show link previews' ")
    void showPreviewTestPOM() {
        back();
        boolean expectedShowPreviewCondition = mainPage
                .clickOnMoreTab()
                .clickOnSettings()
                .checkShowPreviewIsTrue();

        Assertions.assertTrue(expectedShowPreviewCondition);
    }

    @Test
    @DisplayName("Мобильный тест на POM. Проверка switch 'prefer offline' ")
    void preferOfflineTestPOM() {
        back();
        boolean expectedPreferOfflineCondition = mainPage
                .clickOnMoreTab()
                .clickOnSettings()
                .scrollToPreferOffline()
                .checkPreferOfflineIsFalse();

        Assertions.assertTrue(expectedPreferOfflineCondition);
    }
}
