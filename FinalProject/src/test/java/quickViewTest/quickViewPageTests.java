package quickViewTest;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.global.SearchResultPage;
import pages.partiallyGlobal.QuickViewPage;

import static org.testng.Assert.assertEquals;

public class quickViewPageTests extends BaseTests {
    @Test
    public void setQuantity(){
        SearchResultPage searchResultPage = homePage.searchItem("Dress");
        QuickViewPage quickViewPage = searchResultPage.clickQuickView();
        quickViewPage.setQuantity(3);
        assertEquals(quickViewPage.getQuantity(), "3");
        driver.switchTo().defaultContent();
    }

    @Test
    public void testItem(){
        SearchResultPage searchResultPage = homePage.searchItem("Dress");
        QuickViewPage quickViewPage = searchResultPage.clickQuickView();
        assertEquals(quickViewPage.getName(), "Printed Summer Dress");
        assertEquals(quickViewPage.getPrice(), 28.98);
        driver.switchTo().defaultContent();
    }

}
