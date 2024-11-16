import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTest{
    private String[] selectedItems={"Cucumber","Beetroot","Pomegranate","Mushroom"};

    @Test
    public void itemsSelectionTest() throws InterruptedException {
        productPage.chooseProduct(selectedItems)
                        .placeOrder()
                                .proceedCheckout("Egypt");
        //Assert.assertTrue(productPage.getNumberOfProductsInCart(selectedItems),Integer.toString(selectedItems.length));
    }
}
