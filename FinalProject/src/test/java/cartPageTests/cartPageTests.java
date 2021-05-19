package cartPageTests;

import base.BaseTests;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.global.SearchResultPage;
import pages.partiallyGlobal.CartPage;
import utils.NavigateGlobalPages;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class cartPageTests extends BaseTests {
    @Test
    public void testTotalPrice(){
        setupItems();
        CartPage cartPage = NavigateGlobalPages.goToCartPage(driver);
        assertEquals( cartPage.getTotalPrice() ,112.47);
    }

    @Test
    public void testRemoveFromCart(){
        setupItems();
        CartPage cartPage = NavigateGlobalPages.goToCartPage(driver);
        // id 5_19_0_0 costs 28.98
        // id 4_16_0_0 costs 50.99
        // id 6_31_0_0 costs 30.50
        // we remove the second item from the list hence the price will be down by 50.99
        cartPage.removeFromCart("6_31_0_0");
        assertEquals( cartPage.getTotalPrice() ,61.48);
    }

    private void setupItems(){
        SearchResultPage searchResultPage = homePage.searchItem("Dress");
        List<WebElement> elementList = searchResultPage.getProductContainerList();

        int numOfClothes = 3;
        for(int i = 0; i < numOfClothes; i++){
            new WebDriverWait(driver, 20).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            NavigateGlobalPages.addToCart(driver, elementList.get(i));
        }
    }
}
