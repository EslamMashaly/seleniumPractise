import org.testng.Assert;
import org.testng.annotations.Test;

public class StaticDropDownTests extends BaseTest {

    @Test
    public void currencyStaticDropDownTest(){

        dropDownPage.selectCurrencyByValue("USD");
        var selectedOptions=dropDownPage.getSelectedOptions();
        Assert.assertEquals(selectedOptions.size(),1); //to make sure that only one option is selected
        Assert.assertTrue(selectedOptions.contains("USD"));

//        dropDownPage.selectCurrencyByIndex(2);
//         selectedOptions=dropDownPage.getSelectedOptions();
//        Assert.assertEquals(selectedOptions.size(),1); //to make sure that only one option is selected
//        Assert.assertTrue(selectedOptions.contains("AED"));
//
//
//        dropDownPage.selectCurrencyByIndex(2);
//         selectedOptions=dropDownPage.getSelectedOptions();
//        dropDownPage.selectCurrencyByValue("INR");
//        Assert.assertTrue(selectedOptions.contains("INR"));

    }
@Test
    public void passengersStaticDropDown() throws InterruptedException {
        dropDownPage.selectNumberOfPassengers("adult",3);
        dropDownPage.selectNumberOfPassengers("child",1);
        dropDownPage.selectNumberOfPassengers("infant",2);
    }

}