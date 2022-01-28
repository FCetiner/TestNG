package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C03_MouseActions extends TestBase {
    //1- Yeni bir class olusturalim: MouseActions1

    @Test
    public void test01(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement ciziliAlanElementi= driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlanElementi).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedYazi="You selected a context menu";
        String actuelYazi= driver.switchTo().alert().getText();
        Assert.assertEquals(actuelYazi,expectedYazi);
        //5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[.='Elemental Selenium']")).click();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String ikinciSayfaHandleDegeri="";
        Set<String> handleDegerleriSet=driver.getWindowHandles();
        for(String each:handleDegerleriSet){
            if(!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri=each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleDegeri);

        WebElement h1TagElementi=driver.findElement(By.tagName("h1"));
        String actuelIkınciSayfaYazi=h1TagElementi.getText();
        String expectedTitle="Elemental Selenium";
        Assert.assertEquals(actuelIkınciSayfaYazi,expectedTitle);


    }

}
