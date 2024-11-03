package pages;

import dev.failsafe.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ProductPage {
    private WebDriver driver;

    private By products = By.xpath("//div[@class='product'] //h4");
    private By addToCartButton = By.xpath("//div[@class='product-action'] //button");
    private By cartButton = By.cssSelector("a.cart-icon");
    private By cartProducts = By.xpath("//div[@class='cart-preview active' ] //p[@class='product-name']");
    private By proceedToCheckoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }


    private void waits(WebElement element) {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void chooseProduct(String[] selectedItems) {
        //My method
        //
//       List<WebElement> allItems=driver.findElements(products);
//       for (int i = 0; i <allItems.size() ; i++) {
//           String itemName= allItems.get(i).getText();
//           for (int j = 0; j <selectedItems.length ; j++) {
//               String name=selectedItems[j];
//               if (itemName.contains(name)){
//                   driver.findElements(addToCartButton).get(i).click();
//               }
//           }
//           }
        int j = 0;
        List<WebElement> allItems = driver.findElements(products);
        List selectedItemsList = Arrays.asList(selectedItems);
        for (int i = 0; i < allItems.size(); i++) {
            String[] itemName = allItems.get(i).getText().split("-");
            String formattedItemName = itemName[0].trim();
            if (selectedItemsList.contains(formattedItemName)) {
                j++;
                driver.findElements(addToCartButton).get(i).click();
                if (j == selectedItems.length) {
                    break;

                }
            }
        }
    }

    public boolean productsInCart(String[] selectedItems) {
//        waits(driver.findElement(proceedToCheckoutButton));
        driver.findElement(cartButton).click();
        int j = 0;
        List selectedItemsList = Arrays.asList(selectedItems);
        List<WebElement> cartItems = driver.findElements(cartProducts);
        for (int i = 0; i < cartItems.size(); i++) {
            String[] cartItemsName = cartItems.get(i).getText().split("-");
            String formattedCartItemName=cartItemsName[0].trim();
            if (selectedItemsList.contains(formattedCartItemName)) {
                j++;
            }
        }
            if (j == selectedItemsList.size())
                return true;
            else{
                return false;

            }

    }

   }

