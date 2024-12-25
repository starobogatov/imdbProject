package imdb;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.SearchType;
import imdb.pageobjects.SearchResultsPage;
import logging.Log;
import org.openqa.selenium.Keys;

import java.util.Properties;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static config.TestConfiguration.loadConfiguration;
import static enums.SearchType.TITLES;

public class ImdbMainPage {

    private static final Properties properties = loadConfiguration();
    private static final String imdbUrl = properties.getProperty("imdb.url");

    private static final SelenideElement
            categoryDropdown = $("[data-testid='category-selector-button']"),
            searchInputField = $("#suggestion-search"),
            cookiesPopUp = $("[data-testid='consent-banner']");

    private static final ElementsCollection
            openedMenuItems = $$(".ipc-menu--open li");

    public static ImdbMainPage openImdbMainPageAndAcceptCookies() {
        String baseUrl = imdbUrl + "/?ref_=nv_home";
        open(baseUrl);

        cookiesPopUp.shouldBe(visible)
                .$("[data-testid='accept-button']").as("'Accept cookies' button")
                .shouldBe(visible, enabled).click();

        Log.info("Opening " + baseUrl);
        return new ImdbMainPage();
    }

    public SearchResultsPage searchForMovie(String title) {
        openMenuAllAndSelectSearchType(TITLES);

        searchInputField.shouldBe(visible)
                .setValue(title).sendKeys(Keys.ENTER);

        Log.info("Searching for movie '{}'", title);
        return new SearchResultsPage(title);
    }

    private void openMenuAllAndSelectSearchType(SearchType text) {
        categoryDropdown.click();
        openedMenuItems
                .findBy(text(String.valueOf(text)))
                .shouldBe(visible)
                .click();
    }
}