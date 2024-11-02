import org.testng.annotations.Test;
import pages.ProductPage;

public class ProductsTests extends BaseTest{
    private String[] selectedItems={"Cucumber","Beetroot","Pomegranate","Mushroom"};

    @Test
    public void itemsSelectionTest() throws InterruptedException {
        productPage.chooseProduct(selectedItems);
         System.out.println(productPage.assertOnProducts(selectedItems));
    }
}
