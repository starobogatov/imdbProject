package imdb.pageobjects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class MovieDetailsPage {

    private static final String AWARDS_SELECTOR = "[data-testid='awards']";

    public MovieDetailsPage(String title) {
        $("h1 .hero__primary-text").shouldBe(visible)
                .shouldHave(text(title));
    }

    public void navigateToAwardsPage() {
        $(AWARDS_SELECTOR)
                .scrollIntoView(true)
                .shouldBe(visible, enabled)
                .click();

        new AwardsPage();
    }

}
