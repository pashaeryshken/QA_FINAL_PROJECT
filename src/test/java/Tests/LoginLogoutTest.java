package Tests;

import Fixtures.BrowserFixture;
import PageObjects.LoginPage;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginLogoutTest extends BrowserFixture {

    LoginPage loginPage;

    @BeforeEach
    public void preConditions(){
        open("?controller=my-account");
        loginPage = new LoginPage();
    }

    @Test
    public void correctLoginTest(){
        loginPage.setUserData("qwerty@mail.ru", "qwerty");
        $("h1").shouldHave(Condition.text("MY ACCOUNT"));
    }

    @Test
    public void unCorrectLoginTest(){
        loginPage.setUserData("qwy@mail.ru", "qw");
        $("div.alert-danger").shouldBe(Condition.visible);
    }

    @Test
    public void signOutTest(){
        loginPage.setUserData("qwerty@mail.ru", "qwerty");
        loginPage.logout();
        $("logout").shouldNotBe(Condition.exist);
    }
}
