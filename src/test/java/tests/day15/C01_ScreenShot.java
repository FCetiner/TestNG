package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C01_ScreenShot extends TestBase {

    @Test
    public void nutellaTesti() throws InterruptedException, IOException {
        //amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        // nutalle icin arama yapalim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonuclarin nutella icerdigini test edelim
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='sg-col-inner']"));

        String sonucSayisiStr=sonucYazisiElementi.getText();

        Assert.assertTrue(sonucSayisiStr.contains("Nutella"));

        Thread.sleep(3000);
        //testin calistigini ispat icin tum sayfanin ss alin
        //tum sayfa screenshot icin dort adim gerekli
        //1. adim TakeScreenShot objesi olusturma

        TakesScreenshot tss=(TakesScreenshot) driver;

        //2. kaydedecegimiz dosyayi olusturalim

        File tumSayfaSS= new File("target/screenshot/tumsayfa.png");

        //3. adim bir dosya daha olsuturup screenshot objesi ile ss alalim

        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        //gecici resmi kaydetmek istedigimiz asil dosyaya copy yapalim

        FileUtils.copyFile(geciciResim,tumSayfaSS);
    }
}
