package tests.day15;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenShotWebElement extends TestBase {

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
        //testin calistigini ispat icin sonuc yazisi webelementinin ss alin


        //tum sayfa screenshot icin dort adim gerekli
        //1. adim Screenshot cekecegimiz webelementi locate edelim


        //2. kaydedecegimiz bir file olusturalim
        File webElementSS=new File("target/screenshot/webElement.jpeg");


        //3. adim bir dosya daha olsuturup screenshot objesi ile ss alalim

        File geciciResim=sonucYazisiElementi.getScreenshotAs(OutputType.FILE);


        //4. gecici resmi kaydetmek istedigimiz asil dosyaya copy yapalim

        FileUtils.copyFile(geciciResim,webElementSS);

    }
}
