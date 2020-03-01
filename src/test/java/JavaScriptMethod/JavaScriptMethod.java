package JavaScriptMethod;

import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JavaScriptMethod {

    public static void hoverProductElement(WebElement element){
        executeJavaScript(
                "$(arguments[0]).addClass('hovered')",
                element
        );
    }
}
