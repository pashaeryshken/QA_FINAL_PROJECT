package PageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductsPage {


    private SelenideElement searchProductElement(String productName){
        return $$(".product_list > li").find(text(productName)).hover();
    }

    public void openDescriptionProduct(String productName){
        searchProductElement(productName).$(byText("More")).click();
    }

    public ProductsPage addProductToCart(String productName){
        searchProductElement(productName).$(".right-block").$(byText("Add to cart")).click();
        return this;
    }

    public void addProductToWishList(String productName){
        searchProductElement(productName).find(".wishlist").click();
    }

    public void addProductToCartWithParameters(String quantity, String color, String size){
        $("#quantity_wanted").setValue(quantity);
        if (color != null && size != null) {
            $("#color_to_pick_list>li>a[name='" + color + "']").click();
            $("#group_1").selectOption(size);
        }
        $("#add_to_cart button").click();
    }
    public void addProductToCartWithParameters(String quantity){
        addProductToCartWithParameters(quantity, null, null);
    }

    public void getSuccessMessageAddToCartTest(){
        $("#layer_cart h2").shouldBe(visible);
    }
}
