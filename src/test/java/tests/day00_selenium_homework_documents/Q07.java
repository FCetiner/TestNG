package tests.day00_selenium_homework_documents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class Q07 extends TestBase {
// 1) "https://www.facebook.com/" SAYFASINA GiDiN

    // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
    // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
    // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
    // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN



   @Test
    public void test01(){
       driver.get("https://www.facebook.com");
       driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
       WebElement gunOptions=driver.findElement(By.xpath("//select[@id='day']"));
       Select selectGun=new Select(gunOptions);
       List<WebElement> gunListesi=selectGun.getOptions();
       System.out.println("Gün Listesi:\n");
       for(WebElement each: gunListesi){
           System.out.print(each.getText()+" ");
       }
       System.out.println();
       WebElement ayOptions=driver.findElement(By.xpath("//select[@id='month']"));
       Select selectAy=new Select(ayOptions);
       List<WebElement>ayListesi= selectAy.getOptions();
       System.out.println("Ay Listesi:\n");
       for(WebElement each:ayListesi){
           System.out.print(each.getText()+" ");
       }
       System.out.println();
       WebElement yilOptions=driver.findElement(By.xpath("//select[@id='year']"));
       Select selectYil=new Select(yilOptions);
       List<WebElement>yilListesi= selectYil.getOptions();
       System.out.println("Yil Listesi:\n");
       for(WebElement each:yilListesi){
           System.out.print(each.getText()+" ");
       }


   }










}
