import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoSuggestionDropDownTests extends BaseTest {
    @Test
    public void selectCountryFromSuggestions() throws InterruptedException {
        dropDownPage.enterCountry("eg");
        Assert.assertEquals(dropDownPage.getSuggestedCountries(),"Egypt");
    }
}
