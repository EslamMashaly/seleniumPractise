package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DropDownPage {
    private WebDriver driver;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    private By currencyStaticDropDown = By.id("ctl00_mainContent_DropDownListCurrency");
    private By passengersStaticDropDown = By.id("divpaxinfo");
    private By addAdultsOption = By.id("hrefIncAdt");
    private By addChildOption = By.id("hrefIncChd");
    private By addInfantOption = By.id("hrefIncInf");
    private By autoSuggestDropDown = By.id("autosuggest");
    private By autoSuggestOptions = By.xpath("//li[@class='ui-menu-item'] //a");


    private Select findCurrencyDropDown() {
        return new Select(driver.findElement(currencyStaticDropDown));
    }

    public void selectCurrencyByIndex(int index) {
        findCurrencyDropDown().selectByIndex(index);
    }

    public void selectCurrencyByValue(String option) {
        findCurrencyDropDown().selectByValue(option);
    }

    public void selectCurrencyByVisibleText(String text) {
        findCurrencyDropDown().selectByVisibleText(text);
    }


    public List<String> getSelectedOptions() {
        int numberOfOptions = findCurrencyDropDown().getAllSelectedOptions().size();
        List<WebElement> selectedOptions = findCurrencyDropDown().getAllSelectedOptions();
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < numberOfOptions; i++) {
            a.add(selectedOptions.get(i).getText());
            System.out.println(a);
        }

        return a;
    }

    /**Enhanced version**/
//    public List<String> getSelectedOptions() {
//        List<WebElement> selectedOptions = findCurrencyDropDown().getAllSelectedOptions();
//        List<String> selectedOptionTexts = new ArrayList<>();
//
//        for (WebElement option : selectedOptions) {
//            selectedOptionTexts.add(option.getText());
//        }
//
//        return selectedOptionTexts;
//    }



    public void selectNumberOfPassengers(String passenger, int numberOfPassengers) throws InterruptedException {


        switch (passenger) {
            case "adult":
                driver.findElement(passengersStaticDropDown).click();
                Thread.sleep(1000);
                for (int i = 0; i <= numberOfPassengers; i++) {
                    driver.findElement(addAdultsOption).click();
                    i++;
                }
                break;
            case "child":
                for (int j = 0; j <= numberOfPassengers; j++) {
                    driver.findElement(addChildOption).click();
                    j++;
                }
                break;
            case "infant":
                for (int k = 0; k <= numberOfPassengers; k++) {
                    driver.findElement(addInfantOption).click();
                    k++;
                }
                break;
            default:
                System.out.println("please choose passengers");
        }

    }

    public void enterCountry(String country) throws InterruptedException {
        /**Enhanced version**/
//        driver.findElement(autoSuggestDropDown).sendKeys(country);
//        Thread.sleep(3000);
//        List<WebElement> suggestedCountries = driver.findElements(autoSuggestOptions);
//for (WebElement option :suggestedCountries){
//    if (option.getText().equalsIgnoreCase("Egypt")){
//        option.click();
//        break;
//    }
//}
        driver.findElement(autoSuggestDropDown).sendKeys(country);
        Thread.sleep(3000);
        List<WebElement> suggestedCountries = driver.findElements(autoSuggestOptions);
        for (int i = 0; i < suggestedCountries.size(); i++) {
            if (suggestedCountries.get(i).getText().equalsIgnoreCase("Egypt")) {
                suggestedCountries.get(i).click();
                break;
            }
        }
    }

    public String getSuggestedCountries() {
        return driver.findElement(autoSuggestDropDown).getText();
    }


}


