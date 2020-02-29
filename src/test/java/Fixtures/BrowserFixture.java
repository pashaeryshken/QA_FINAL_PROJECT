package Fixtures;

import Watchers.ScreenShooterLog;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

import static com.codeborne.selenide.Selenide.*;

/*@ExtendWith(ScreenShooterLog.class)*/
public class BrowserFixture {

    @BeforeAll
    public static void startBrowser() throws MalformedURLException {
        Configuration.baseUrl= "http://automationpractice.com/index.php";
        Configuration.browser= "chrome";
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browserSize = "1980x1080";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

    }

    @AfterEach
    public void postConditions(){
        clearBrowserCookies();
    }

}
