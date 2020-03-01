package Tests;

import Fixtures.BrowserFixture;
import PageObjects.CartPage;
import PageObjects.ProductsPage;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartTest extends BrowserFixture {

    CartPage cartPage;

    @BeforeEach
    public void preConditions(){
        open("/");
        new ProductsPage().addProductToCart("Blouse")
                          .getSuccessMessageAddToCartTest();
        open("?controller=order");
        cartPage = new CartPage();
    }

    @Test
    public void addProductToCartTest(){
        cartPage.searchProductInCart("Blouse").shouldBe(Condition.visible);
    }

    @Test
    public void removeProductFromCartTest(){
        cartPage.removeProductFromCart("Blouse").shouldNotBe(Condition.exist);
    }

    @Test
    public void orderFormationTest(){
        cartPage.orderFormation();
        $(".alert-success").shouldBe(Condition.text("Your order on My Store is complete."));
    }
}
