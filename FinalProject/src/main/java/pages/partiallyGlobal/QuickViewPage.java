package pages.partiallyGlobal;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.Page;
import utils.NavigateGlobalPages;

import static utils.FieldNames.*;

public class QuickViewPage extends Page {
    public QuickViewPage(WebDriver driver) {
        super(driver);
        driver.switchTo().frame(0);
    }

    @Override
    protected void setupElementLocators() {
        elementLocators.put(ADD_TO_CART, By.className("exclusive"));
        elementLocators.put(NAME, By.xpath("//h1[@itemprop='name']"));
        elementLocators.put(QUANTITY_WANTED, By.id("quantity_wanted"));
        elementLocators.put(PRICE, By.id("our_price_display"));
    }

    public void addToCart(){
        findElementBy(elementLocators.get(ADD_TO_CART)).click();
        NavigateGlobalPages.handleAddToCartResponse(driver, true);
    }

    public String getName(){
        return findElementBy(elementLocators.get(NAME)).getText();
    }

    public Double getPrice(){
        String price = findElementBy(elementLocators.get(PRICE)).getText();
        price = price.replace("\t", "");
        price = price.replace("\n", "");
        Double productPrice = Double.parseDouble(price.substring(1));
        return productPrice;
    }

    public void setQuantity(int quantity){
        findElementBy(elementLocators.get(QUANTITY_WANTED)).sendKeys(Keys.BACK_SPACE + "" + quantity);
    }

    public String getQuantity(){
        return findElementBy(elementLocators.get(QUANTITY_WANTED)).getAttribute("value");
    }


}
