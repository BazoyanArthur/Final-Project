package searchResultTest;

import base.BaseTests;
import org.testng.annotations.Test;
import utils.Product;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class searchResultTests extends BaseTests {
    @Test
    public void testSearchBarForSpecificItem(){
        List<Product> products = homePage.findItem("Faded Short Sleeve T-shirts");
        Product expectedProduct = new Product("Faded Short Sleeve T-shirts", "Faded short sleeve t-shirt with high neckline." +
                " Soft and stretchy material for a comfortable fit. Accessorize with a straw hat and you're ready for summer!",
                16.51, true);
        assertEquals(products.get(0), expectedProduct);
    }

    @Test
    public void testSearchBarForDresses(){
        List<Product> products = homePage.findItem("Dress");
        int topSearchResultNumber = 4;
        for(int i = 0; i < topSearchResultNumber; i++){
            assertTrue(products.get(i).getName().contains("Dress"));
        }
    }


}
