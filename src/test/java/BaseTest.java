import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.DropDownPage;

public class BaseTest {

    private WebDriver driver;
    protected DropDownPage dropDownPage;
@BeforeTest
    public void setTest(){
        driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        dropDownPage=new DropDownPage(driver);
    }
//@AfterTest
//    public void tearDown(){
//        driver.quit();
//    }
}
