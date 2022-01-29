package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Senkronizasyon extends TestBase {

    @Test
    public void test01() throws InterruptedException {
    //https://the-internet.herokuapp.com/dynamic_controls
        //sayfasina gidin disable butonuna basin disabled yazisinin ciktigini test edin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[.='Enable']")).click();
        Thread.sleep(3000);
        WebElement actualYazi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(actualYazi.isDisplayed());


        //net olarak beklememiz gereken sure varsa, sonucu gormek icin vs icin Thread.sleep
        //sayfanın yuklenmesi icin max 15 saniyeye kadar zaman tanir implicitly wait
        //cok specific bir gorev geldi test sırasinda 45 sn,3dk gorev geldi, bu sure bilgisayar
        //hizina gore degisiyorsa expilictly wait kullaniriz. sadece bir islem icin tanimlanir.
        // o isi yapinca sonraki koda gecer.
        //implicitly wait-> global bir bekleme suresidir
        //explicitly wait-> specific bir eylem icin ozel olarak olusturulan bir kosuldur
        //Thread.sleep hard sleepdir beklenen sure kadar bekle javadan gelir
        //implicitly-> dinamik bir bekleme suresidir gorev tamamlaninca gecer


        //senkronizasyon kodlarimizin bilgisayar ve interne hizi ile uyumlu calismasini saglar


    }
}
