package imdb;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

import java.util.Properties;

import static config.TestConfiguration.loadConfiguration;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Long.parseLong;

public class BaseTest {

    private static final String
            BROWSER = "selenide.browser",
            HEADLESS = "selenide.headless",
            TIMEOUT = "selenide.timeout";

    private static final String CHROME_OPTIONS = String.join(",",
            "--incognito",
            "--disable-infobars",
            "--enable-automation",
            "--disable-browser-side-navigation",
            "--lang=en-US");

    private static final String
            CHROME_PREFS = "disable-features=NetworkService",
            BROWSER_SIZE = "1400x864";

    @BeforeClass
    public final void setupSelenide() {
        Properties properties = loadConfiguration();
        configureBrowser(properties);
        configureSelenide(properties);
    }

    private void configureBrowser(Properties properties) {
        Configuration.browser = properties.getProperty(BROWSER);
        System.setProperty("chromeoptions.args", CHROME_OPTIONS);
        System.setProperty("chromeoptions.prefs", CHROME_PREFS);
    }

    private void configureSelenide(Properties properties) {
        Configuration.headless = parseBoolean(properties.getProperty(HEADLESS));
        Configuration.browserSize = BROWSER_SIZE;
        Configuration.pageLoadTimeout = parseLong(properties.getProperty(TIMEOUT));
    }
}
