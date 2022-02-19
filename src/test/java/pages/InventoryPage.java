package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String productName) {
        driver.findElement(By.xpath ("//div[contains(text(),'"+productName+ "')]/../../..//button") ).click();

    }

}
