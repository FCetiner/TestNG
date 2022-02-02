package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_ScreenShot extends TestBase {

    @Test
    public void screenTest(){
        driver.get("https://www.google.com");
        //tüm sayfanin screen shotunu almak icin
        //1. adim screenshot almak icin obje olusturalim ve deger olarak driverimizi atayalim
        //deger olarak driveri kabul etmek icin casting yapmamiz gerekir
        TakesScreenshot tss=(TakesScreenshot) driver;

        //2. adim tum sayfanin screenshotini almak icin bir File olusturalim ve
        //dosya yolunu belirtelim

        File tumSayfaSS=new File("src/tumSayfa.png");

        //3. adim olusturdugumuz file ile takeScreenshot objesini ilskilendirelim

        tumSayfaSS=tss.getScreenshotAs(OutputType.FILE);

        //eger specific bir web elementinin screenshotunu almak istiyorsaniz

        WebElement logoElement=driver.findElement(By.id("hplogo"));

        File logoResmi=new File("src/logo.png");
        logoResmi=logoElement.getScreenshotAs(OutputType.FILE);


    }
}
