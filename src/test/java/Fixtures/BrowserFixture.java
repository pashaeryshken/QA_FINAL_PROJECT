package Fixtures;

import Watchers.ScreenShooterLog;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.remote.DesiredCapabilities;



import static com.codeborne.selenide.Selenide.*;

@ExtendWith(ScreenShooterLog.class)
public class BrowserFixture {

    @BeforeAll
    public static void startBrowser() {
        Configuration.baseUrl= "http://automationpractice.com/index.php";
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browserSize = "1980x1080";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", false);
        capabilities.setCapability("enableVideo", false);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void postConditions(){
        clearBrowserCookies();
    }

}
