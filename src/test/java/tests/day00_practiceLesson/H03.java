package tests.day00_practiceLesson;

import com.github.javafaker.Faker;
import com.github.javafaker.Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class H03 extends TestBase {
    //twitter a faker class kullanarak kayit olmaya calisiniz
    //action class kullanilmadan

    @Test
    public void test01() throws IOException, InterruptedException {
        //twitter.com adresine gidin
        driver.get("https://www.twitter.com");
        //hesap olustur butonuna tiklayin
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[.='Telefon numarası veya e-posta adresiyle kaydol']")).click();
        //isim girin
        Faker faker=new Faker();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(faker.name().firstName());
        //eposta kullan butonuna tiklayin
        driver.findElement(By.xpath("//span[.='E-posta kullan']")).click();
        //E posta girin
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(faker.internet().emailAddress());
        //Ay girin
        WebElement ayElement=driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
        Select selectAy=new Select(ayElement);
        selectAy.selectByIndex(faker.random().nextInt(1,12));
        //gun girin
        WebElement gunElement=driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
        Select selectGun=new Select(gunElement);
        selectGun.selectByIndex(faker.random().nextInt(1,30));
        //yıl girin
        WebElement yilElement=driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
        Select selectYil=new Select(yilElement);
        selectYil.selectByIndex(faker.random().nextInt(20,90));
        //ileri tusuna basin
        driver.findElement(By.xpath("(//div[@role='button'])[3]")).click();
        //ileri tusuna basin
        driver.findElement(By.xpath("(//div[@role='button'])[2]")).click();
        //kaydol tusuna basin
        driver.findElement(By.xpath("//span[.='Kaydol']")).click();
        //Sana bir kod gönderdik. yazisi ciktigini teyit edin
        WebElement sanaKodGonderdikWebElementi=driver.findElement(By.xpath("//span[.='Sana bir kod gönderdik.']"));
        String expectedText="Sana bir kod gönderdik.";
        String actualText=sanaKodGonderdikWebElementi.getText();
        Assert.assertEquals(actualText,expectedText);
        TakesScreenshot tss=(TakesScreenshot) driver;
        File webElementSS=new File("target/screenshot/kayitOlunduSS.jpeg");
        File geciciResim=sanaKodGonderdikWebElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,webElementSS);

    }
}
