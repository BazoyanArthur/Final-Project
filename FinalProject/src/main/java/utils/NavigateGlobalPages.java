package utils;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.partiallyGlobal.CartPage;

import static utils.FieldNames.CART;

public class NavigateGlobalPages {

    private static ImmutableMap<String, By> pageTransitions = ImmutableMap.<String, By>builder()
            //.put(CART, By.xpath("//a[@title='View my shopping cart']"))
            .put(CART, By.xpath("//a[@title='View my shopping cart']"))

            .build();

    public static CartPage goToCartPage(WebDriver driver){
        checkDriver(driver);
        driver.findElement(pageTransitions.get(CART)).click();
        return new CartPage(driver);
    }

    public static void addToCart(WebDriver driver, WebElement itemContainer){
        new CartPage(driver).addToCart(itemContainer);
    }


    private static void checkDriver(WebDriver driver){
        if(driver == null){
            throw new InvalidArgumentException("Driver cannot be Null");
        }
    }
}
