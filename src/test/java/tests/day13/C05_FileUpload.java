package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    //Tests packagenin altina bir class oluşturun : C05_UploadFile

    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim

        //Yuklemek istediginiz dosyayi secelim.
        //1-File secme butonunu locate edelim

        WebElement fileSecButonu=driver.findElement(By.id("file-upload"));

        //2 yukleyecegimiz dosyanin dinamik yolunu hazirlayalim path
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\deneme\\selenium.txt";

        //3- sendkeys methodu ile dinamik pathi dosya sec butonuna tiklayalim

        fileSecButonu.sendKeys(dosyaYolu);
        Thread.sleep(7000);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim
        WebElement sonucYazisiElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(sonucYazisiElementi.isDisplayed());


    }




}
