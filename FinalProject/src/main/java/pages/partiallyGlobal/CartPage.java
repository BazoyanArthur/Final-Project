package pages.partiallyGlobal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.Page;

import static utils.FieldNames.*;

public class CartPage extends Page {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void setupElementLocators() {
        elementLocators.put(TOTAL_PRICE, By.id("total_price"));
    }

    public Double getTotalPrice(){
        String price = findElementBy(elementLocators.get(TOTAL_PRICE)).getText();
        return Double.parseDouble(price.substring(1));
    }



}
