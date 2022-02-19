package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartItemName(int index){
        return driver.findElements(By.cssSelector(".inventory_item_name")).get(index).getText();

    }
}
