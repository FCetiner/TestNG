package tests.day14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_Explicitly extends TestBase {

    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //     Iki metod icin de asagidaki adimlari test edin.


    @Test
    public void implicitlyWaitTesti(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElement=driver.findElement(By.xpath("//p[.=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElement.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackElement=driver.findElement(By.xpath("//p[@id='message']"));

        Assert.assertTrue(itsBackElement.isDisplayed());
    }

    @Test
    public void explicitlyWaitTesti(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //explicitlywait kullanabilmek icin once wait objesi olusturmaliyiz
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        //4. Remove butonuna basin
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        //Her ne kadar kodun anlasilabilir olmasi icin once locate edelim sonra bekleyelim yaklasimi daha guzel
       // gorunsede webElemen gotunur olmadıgından calismayabilir
      //  WebElement itsGoneElement=driver.findElement(By.xpath("//p[.=\"It's gone!\"]"));
      //  wait.until(ExpectedConditions.visibilityOf(itsGoneElement));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.=\"It's gone!\"]")));
        WebElement itsGoneElement=driver.findElement(By.xpath("//p[.=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElement.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        //7. It’s back mesajinin gorundugunu test edin
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement itsBackElement=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElement.isDisplayed());
    }

}
