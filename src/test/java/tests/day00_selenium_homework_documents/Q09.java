package tests.day00_selenium_homework_documents;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q09 extends TestBase {
    //   1- https://www.facebook.com adresine gidelim
    //    2- Yeni hesap olustur butonuna basalim
    //    3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

    @Test
    public void test01(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement isimElementi=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        actions.click(isimElementi).keyDown(Keys.SHIFT).sendKeys("f").keyUp(Keys.SHIFT).sendKeys("erhat").sendKeys(Keys.TAB).
                keyDown(Keys.SHIFT).sendKeys("cetiner").keyUp(Keys.SHIFT).sendKeys(Keys.TAB).
                sendKeys("ferhat@gmail.com").sendKeys(Keys.TAB).
                sendKeys("ferhat@gmail.com").sendKeys(Keys.TAB).
                sendKeys("12345678").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("11").sendKeys(Keys.TAB).
                sendKeys("Şubat").sendKeys(Keys.TAB).
                sendKeys("1990").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

    }




}
