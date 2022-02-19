package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.cssSelector("#user-name");
    By password = By.cssSelector("#password");
    By loginButton = By.cssSelector("#login-button");

    public void login(String usernameValue, String passwordValue){
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        clickLoginButton ();
    }

    public void enterUsername(String usernameValue){   //ovde pravimo metod za username
        driver.findElement(username).sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue){  //ovde pravimo metod za pass
        driver.findElement(password).sendKeys(passwordValue);
    }

    public void clickLoginButton(){   //klik na login dugme
        driver.findElement(loginButton).click();
    }

}
