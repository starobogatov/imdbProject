package imdb.pageobjects;

import com.codeborne.selenide.SelenideElement;
import logging.Log;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {

    public static final SelenideElement
            searchResultListSection = $("[data-testid='find-results-section-title']");

    public SearchResultsPage(String text) {
        $(".ipc-page-content-container h1").shouldBe(visible)
                .shouldHave(text("Search \"" + text + "\""));

        searchResultListSection.shouldBe(visible);
    }

    public MovieDetailsPage findAndOpenMovie(String movieYear, String title) {
        $$(".ipc-metadata-list-summary-item .ipc-metadata-list-summary-item__c")
                .find(text(movieYear))
                .shouldHave(text(title))
                .scrollIntoView(true)
                .click();

        Log.info("Found movie with title '{}' and release year '{}'", title, movieYear);

        return new MovieDetailsPage(title);
    }
}
