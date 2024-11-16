package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private By promoCodeField=By.cssSelector("input[class='promoCode']");
    private By applyButton=By.xpath("//button[text()='Apply']");
    private By promoValidationText=By.cssSelector("span[class='promoInfo']");
    private By placeOrderButton=By.xpath("//button[text()='Place Order']");


    public CheckoutPage(WebDriver driver){
        this.driver=driver;
    }

    private void visibilityOfElementWait(By element, int timeInSeconds) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));

        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public TermsAndConditionsPage placeOrder(){
        visibilityOfElementWait(promoCodeField,5);
        driver.findElement(promoCodeField).sendKeys("rahulshettyacademy");
        driver.findElement(applyButton).click();
        visibilityOfElementWait(promoValidationText,5);
        driver.findElement(placeOrderButton).click();
        return new TermsAndConditionsPage(driver);
    }
}
