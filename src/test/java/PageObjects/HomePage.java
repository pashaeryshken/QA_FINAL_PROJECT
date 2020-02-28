package PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {


    public void setSearchBar(String keyWord){
        $("#search_query_top").setValue(keyWord).submit();
    }




}
