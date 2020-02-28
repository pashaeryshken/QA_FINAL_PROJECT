package PageObjects;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {


    public void setUserData(String email, String password){
        $("input#email").setValue(email);
        $("input#passwd").setValue(password);
        $("button#SubmitLogin").click();
    }

    public void logout(){
        $(".logout").click();
    }
}
