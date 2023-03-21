import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Keys;

import java.util.Collection;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Search {
    public SelenideElement inputSearchField = $ (byId ("search_form_input_homepage"));
    public ElementsCollection resultOfSearch = $$ (byClassName("nrn-react-div"));
   @ParameterizedTest
   @MethodSource ("searchDataList")
    public void validSearch (String query){
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
        open ("https://duckduckgo.com/");
        inputSearchField.setValue(query);
        inputSearchField.sendKeys(Keys.ENTER);
        //$(byId("search_form_input_homepage")).sendKeys("Java", Keys.ENTER);


        for (SelenideElement snippet:
                resultOfSearch) {
            snippet.shouldBe(partialText(query));
       }

       /*for (SelenideElement snippet:
            $$ (byClassName("nrn-react-div"))) {
           snippet.shouldHave(text("Java"));}*/

        resultOfSearch.shouldHave(CollectionCondition.size(10));
    }

    private static Stream<Arguments> searchDataList() {
        return  Stream.of(
                Arguments.arguments("Java"),
                Arguments.arguments("Python"),
                Arguments.arguments("Selenide")


        );
    }


}
