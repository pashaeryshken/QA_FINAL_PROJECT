package Fixtures;

import Watchers.ScreenShooterLog;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;

@ExtendWith(ScreenShooterLog.class)
public class BrowserFixture {

    @BeforeAll
    public static void startBrowser(){
        Configuration.baseUrl= "http://automationpractice.com/index.php";
    }

    @AfterEach
    public void postConditions(){
        clearBrowserCookies();
    }
}
