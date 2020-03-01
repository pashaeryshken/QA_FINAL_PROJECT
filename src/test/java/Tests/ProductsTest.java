package Tests;

import Fixtures.BrowserFixture;
import PageObjects.ProductsPage;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ProductsTest extends BrowserFixture {

    ProductsPage productsPage;

    @BeforeEach
    public void preConditions(){
        open("?id_category=3&controller=category");
        productsPage = new ProductsPage();
    }

    @Test
    public void addProductToCart(){
        productsPage.addProductToCart("Blouse");
        productsPage.getSuccessMessageAddToCartTest();
    }

    @Test
    public void addProductWishList(){
        productsPage.addProductToWishList("Faded Short");
        $(".fancybox-error").shouldBe(Condition.text("You must be logged in to manage your wishlist."));
    }

    @Test
    public void addProductToCartWithParameters(){
        productsPage.openDescriptionProduct("Blouse");
        productsPage.addProductToCartWithParameters("2", "Black", "M");
        productsPage.getSuccessMessageAddToCartTest();
    }

    @Test
    public void  addProductToCartWithZeroAmount(){
        productsPage.openDescriptionProduct("Blouse");
        productsPage.addProductToCartWithParameters("0");
        $(".fancybox-error").shouldBe(Condition.text("Null quantity."));
    }
}
