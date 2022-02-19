package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.util.concurrent.TimeUnit;

public class SauceDemoTests extends BaseTest{

    @BeforeMethod
    @Parameters
    ({"BROWSER","BROWSER_VERSION","WAIT_TIME","ENV"})
    //uvodjenjem parametara sve iznad navedeno resavam u XML fajlu SouceDemo.xml
    public void setUP(String browser, String browserVersion, String waitTime, String env) throws Exception {
        setUPTest(browser, browserVersion, Integer.parseInt(waitTime));
//ovde sad pozivamo setuptest klasu, gde smo podesili te opste stavke i samo kao parametre ubacujemo browser i verziju

       // driver.get("https://www.saucedemo.com");
        //sajt koji je predmet testa -> ovo cu prebaciti u Base Test klasu->startSouceDemoApplication() metodu
        //trazice i da zato stavim throws Exception i za ovu metodu setUp()
        startSouceDemoApplication(env);
    }

    @AfterMethod
    public void tearDown(){
        quit();
    }

    @Test
    public void Login() throws InterruptedException { //logon na stranicu
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        //ovo se moze i parametrizovati, pa da tako pokrijemo razlicite scenarije

        Thread.sleep(2000);


        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        //a mozemo i u LoginPage napraviti metodu checkIfUserIsLoggedIn(){i u telo staviti ovo iznad}
        //i onda samo ovde pozvati loginPage.checkIfUserIsLoggedIn();
        //bolja je praksa da se asertacija drzi u testovima, a ako bi se vise puta za razlicite stvari koristila
        // asertacija onda bi bilo opravdano da je smestimo u pages->loginPage
    }

    @Test
    public void AddToCart(){ //klik na proizvod
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage= new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);


        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bike Light");

        //cartPage.getCartItemName(0); // ->ovo mi nazad vraca ime proizvoda koje se nalazi na toj poziciji
        Assert.assertEquals(cartPage.getCartItemName(0), "Sauce Labs Backpack");
        Assert.assertEquals(cartPage.getCartItemName(1), "Sauce Labs Bike Light");



    }
}
//branch1 test
//branch commit2