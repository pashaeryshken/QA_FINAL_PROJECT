package PageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    SelenideElement productElement;

    public SelenideElement searchProductInCart(String productName){
        return $$("#cart_summary>tbody>tr").last().$(".cart_description>p").shouldHave(text(productName));
    }

    public SelenideElement removeProductFromCart(String productName){
        productElement = searchProductInCart(productName);
        productElement.closest("tr").$(".cart_delete a").click();
        return productElement;
    }

    public void orderFormation(){
        $(".cart_navigation>a>span").click();
        new LoginPage().setUserData("qwerty@mail.ru","qwerty");
        $("#center_column>form").submit();
        $("input#cgv").click();
        $("p.cart_navigation button").click();
        $("#HOOK_PAYMENT a.cheque").click();
        $("#center_column form").submit();
    }
}
