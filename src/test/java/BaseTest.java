import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.DropDownPage;
import pages.ProductPage;

public class BaseTest {

    private WebDriver driver;
    protected DropDownPage dropDownPage;
    protected ProductPage productPage;
@BeforeTest
    public void setTest(){
        driver= new ChromeDriver();
//        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        dropDownPage=new DropDownPage(driver);
        productPage=new ProductPage(driver);
    }
//@AfterTest
//    public void tearDown(){
//        driver.quit();
//    }
}
