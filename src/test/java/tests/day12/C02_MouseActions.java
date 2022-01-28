package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C02_MouseActions extends TestBase {
    // amazon anasayfaya gidin
    // sag ustte hello,signIn elementinin uzerinde mouse'u bekletin
    // acilan menude new list linkine tiklayin
    // ve new list sayfasinin acildigini test edin

    @Test
    public void amazonList() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement helloElement = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
         actions.moveToElement(helloElement).perform();
        Thread.sleep(3000);
         WebElement listElement=driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
        actions.click(listElement).perform();

        String actualTitle=driver.getTitle();
        String expectedTitle="Your List";
        Assert.assertTrue(actualTitle.contains(expectedTitle)); //static oldugu icin class ismi ile cagiriliyor

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(expectedTitle)); //static olmadigi icin obje ile cagiriliyor
        softAssert.assertAll();
    }






}
