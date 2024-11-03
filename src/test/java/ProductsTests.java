import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTest{
    private String[] selectedItems={"Cucumber","Beetroot","Pomegranate","Mushroom"};

    @Test
    public void itemsSelectionTest() {
        productPage.chooseProduct(selectedItems);
        Assert.assertTrue(productPage.productsInCart(selectedItems),Integer.toString(selectedItems.length));
    }
}
