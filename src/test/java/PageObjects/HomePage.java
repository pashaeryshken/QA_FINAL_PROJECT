package PageObjects;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {


    public void setSearchBar(String keyWord){
        $("#search_query_top").setValue(keyWord).submit();
    }




}
