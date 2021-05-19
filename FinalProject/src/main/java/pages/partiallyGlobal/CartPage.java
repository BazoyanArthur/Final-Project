package pages.partiallyGlobal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.Page;

import static utils.FieldNames.*;

public class CartPage extends Page {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void setupElementLocators() {
        elementLocators.put(ADD_TO_CART, By.className("exclusive"));
        elementLocators.put(CONTINUE_SHOPPING, By.xpath("//span[@title='Continue shopping']"));
        elementLocators.put(CHECKOUT, By.xpath("//span[@title='Proceed to checkout']"));
        elementLocators.put(TOTAL_PRICE, By.id("total_price"));
    }

    public Double getTotalPrice(){
        String price = findElementBy(elementLocators.get(TOTAL_PRICE)).getText();
        return Double.parseDouble(price.substring(1));
    }

    public void removeFromCart(String itemId){
        findElementBy(By.id(itemId)).click();
    }

    public void  addToCart(WebElement itemContainer){
        itemContainer.findElement(By.xpath(".//a[@class='button ajax_add_to_cart_button btn btn-default']")).click();
        handleAddToCartResponse(false);
    }

    private CartPage handleAddToCartResponse(boolean proceed){
        new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        if(proceed){
            driver.findElement(elementLocators.get(CHECKOUT)).click();
            return new CartPage(driver);
        }else{
            driver.findElement(elementLocators.get(CONTINUE_SHOPPING)).click();
        }
        return null;
    }

}
