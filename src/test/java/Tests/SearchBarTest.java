package Tests;

import Fixtures.BrowserFixture;
import PageObjects.HomePage;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class SearchBarTest extends BrowserFixture {

    HomePage homePage;

    @BeforeEach
    void preConditions() {
        open("/");
        homePage = new HomePage();
    }

    @Test
    void correctSearchProductTest() {
        homePage.setSearchBar("dress");
        ElementsCollection productList = $$("#center_column ul.product_list>li");
        productList.filter(Condition.text("dress")).shouldBe(CollectionCondition.size(productList.size()));
    }

    @Test
    void unCorrectSearchProductSearch(){
        homePage.setSearchBar("Panzer");
        $(".alert-warning").shouldBe(Condition.text("No results were found for your search \"panzer\""));
    }
}
