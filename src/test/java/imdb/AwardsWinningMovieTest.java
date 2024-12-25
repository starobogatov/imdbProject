package imdb;

import org.testng.annotations.Test;

public class AwardsWinningMovieTest extends BaseTest {

    public static final String
            MOVIE_TITLE_TITANIC = "Titanic",
            MOVIE_RELEASE_YEAR = "1997";

    @Test
    public void searchForAwardWinningMovie() {
        ImdbMainPage
                .openImdbMainPageAndAcceptCookies()
                .searchForMovie(MOVIE_TITLE_TITANIC.toLowerCase())
                .findAndOpenMovie(MOVIE_RELEASE_YEAR, MOVIE_TITLE_TITANIC)
                .navigateToAwardsPage();
    }
}
