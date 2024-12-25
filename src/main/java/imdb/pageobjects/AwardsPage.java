package imdb.pageobjects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AwardsPage {

    public AwardsPage() {
        $("h1").shouldBe(visible).shouldHave(text("Awards"));
    }
}
