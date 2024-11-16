package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TermsAndConditionsPage {
    private WebDriver driver;
    private By countryDropDown= By.tagName("select");
    private By checkBox= By.xpath("//input[@type='checkbox']");
    private By proceedButton= By.xpath("//button[text()='Proceed']");

    public TermsAndConditionsPage(WebDriver driver){
    this.driver=driver;
    }

    private Select selectCountry() {
        return new Select(driver.findElement(countryDropDown));
    }

    public void proceedCheckout(String country){
        selectCountry().selectByVisibleText(country);
        driver.findElement(checkBox).click();
        driver.findElement(proceedButton).click();
    }
}
