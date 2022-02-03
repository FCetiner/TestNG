package tests.day00_selenium_homework_documents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class Q12 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //https://www.chanel.com/us/
        driver.get("https://www.chanel.com/us/");
        Thread.sleep(3000);
        //1st test:
        //    1- Accessing the site --> OK if the site is displayed
        WebElement logo=driver.findElement(By.xpath("//img[@class='logo_header']"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(logo.isEnabled(),"Siteye giris yapılamadi");
        //    2- Click on the search bar (on the top menu)
        driver.findElement(By.xpath("(//button[@title='Search'])[2]")).click();
        Thread.sleep(3000);
        //    3- Search for "ROUGE ALLURE"
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='searchInput']"));
        String searchedWord="ROUGE ALLURE";
        searchBox.sendKeys(searchedWord+ Keys.ENTER);
        Thread.sleep(3000);
        //    3- Check if the items of the displayed list contain the searched word
        List<WebElement> displayedList=driver.findElements(By.className("product-list-inline__link"));
        for(WebElement each: displayedList){
            softAssert.assertTrue(each.getText().contains(searchedWord),"Listede ismi ROUGE ALLURE içermeyen urun var");
        }
        //    4- Select the second item of the list
        WebElement secondItem=driver.findElement(By.xpath("(//a[@class='product-list-inline__link'])[2]"));
        String secondItemText=secondItem.getText();
                System.out.println(secondItemText);
        secondItem.click();
        Thread.sleep(3000);
        //    5- Make sure that the displayed product name is the same as the previously selected name.
        String displayedProductName=driver.findElement(By.xpath("//span[@class='heading product-details__title ']")).getText();
        softAssert.assertEquals(secondItemText,displayedProductName);
        softAssert.assertAll();

    }

    @Test
    public void test02() throws InterruptedException {
        //2nd test:
        //    1- Access to the site
        driver.get("https://www.chanel.com/us/");

        //    2- Access to Makeup => Lipstick category (on top menu)
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.xpath("//span[@data-test='lnkAxisCategory_makeup']")).click();
        Thread.sleep(3000);
        WebElement lipstickElement=driver.findElement(By.xpath("//a[@data-event-label='lipstick']"));
        lipstickElement.click();
        //    3- Click on ROUGE ALLURE product
        WebElement rogueAllureProductWebElement=driver.findElement(By.xpath("//span[@data-test='imgPdouct_AxisSearchResultPage_151138']"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",rogueAllureProductWebElement);
        jse.executeScript("arguments[0].click()",rogueAllureProductWebElement);
        //    4- Add the product to the cart
        driver.findElement(By.id("pos-cnc-btn")).click();
        //    5- View Cart --> OK, if there is a "ROUGE ALLURE" product in the cart, the quantity=1 and the total cart is equal to the product price.
        boolean nameTestInTheBag=driver.findElement(By.xpath("//span[@data-test='lblProductTitle_151138']")).getText().contains("ROUGE ALLURE");
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(nameTestInTheBag);
        boolean quantityTestInTheBag=driver.findElement(By.xpath("//p[@data-test='lblProductQty_151138']")).getText().contains("1");
        softAssert.assertTrue(quantityTestInTheBag);
        String totalCartPrice=driver.findElement(By.xpath("//p[@data-test='lblSubTotal_Price']")).getText();
        String productPrice=driver.findElement(By.xpath("//p[@data-test='lblProductPrice_151138']")).getText();
        softAssert.assertEquals(productPrice,totalCartPrice);
        softAssert.assertAll();
    }




}
