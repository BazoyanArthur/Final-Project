package utils;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import pages.partiallyGlobal.CartPage;

import static utils.FieldNames.CART;
import static utils.FieldNames.*;

public class NavigateGlobalPages {

    private static ImmutableMap<String, By> pageTransitions = ImmutableMap.<String, By>builder()
            .put(CART, By.xpath("//a[@title='View my shopping cart']"))
            .put(CONTINUE_SHOPPING, By.xpath("/span[@title='Continue shopping']"))
            .put(CHECKOUT, By.xpath("/span[@title='Proceed to checkout']"))
            .build();

    public static CartPage goToCartPage(WebDriver driver){
        checkDriver(driver);
        driver.findElement(pageTransitions.get(CART)).click();
        return new CartPage(driver);
    }


    /**
     *
     * @param proceed is true if the user wants to check out.
     *                false otherwise
     */
    public static CartPage handleAddToCartResponse(WebDriver driver, Boolean proceed){
        checkDriver(driver);
        if(proceed){
            driver.findElement(pageTransitions.get(CHECKOUT)).click();
            return new CartPage(driver);
        }else{
            driver.findElement(pageTransitions.get(CONTINUE_SHOPPING)).click();
        }
        return null;
    }


    private static void checkDriver(WebDriver driver){
        if(driver == null){
            throw new InvalidArgumentException("Driver cannot be Null");
        }
    }
}
