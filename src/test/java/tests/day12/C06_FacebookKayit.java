package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_FacebookKayit extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        //2- Yeni hesap olustur butonuna basalim
        WebElement kayitOlElementi=driver.findElement(By.xpath("//a[.='Yeni Hesap Oluştur']"));
        kayitOlElementi.click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isimElementi=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        actions.
                keyDown(Keys.SHIFT).
                sendKeys("f").
                keyUp(Keys.SHIFT).
                sendKeys("erhat").
                    sendKeys(Keys.TAB).
                keyDown(Keys.SHIFT).
                sendKeys("cetiner").
                keyUp(Keys.SHIFT).
                    sendKeys(Keys.TAB).
                sendKeys("birmail").
                    keyDown(Keys.ALT).
                    keyDown(Keys.CONTROL).
                sendKeys("q").
                    keyUp(Keys.ALT).
                    keyUp(Keys.CONTROL).
                sendKeys("hotmail.com").
                    sendKeys(Keys.TAB).
                sendKeys("12345678").
                    sendKeys(Keys.TAB).
                    sendKeys(Keys.TAB).
                sendKeys("15").
                    sendKeys(Keys.TAB).
                sendKeys("Ş").
                    sendKeys(Keys.TAB).
                sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        Thread.sleep(3000);

    }


}
