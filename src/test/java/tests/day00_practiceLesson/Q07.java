package tests.day00_practiceLesson;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import static org.testng.TestRunner.PriorityWeight.dependsOnMethods;

public class Q07 extends TestBase {
    /*
Alert alert = driver.switchTo().alert();  //bu sekilde de kullanimi mevcuttur
driver.switchTo().alert();     yerine    Alert data turundeki alert variable ini kullandik.
alert variable ile methodlara ulasilabilir
    alert.dismiss();
    alert.accept();  vb
    bu kullanim sayesinde switchto() yazmamiza gerek kalmaz
 */
    //Test edin deyince hard assert, verify deyince soft asser kullanilir


    /*
     // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
     // 2. CLICK ME of JavaScript Alert e tıklayın
     // 3. pop up text i alın
     // 4. Mesajın "I am an alert box!"  olduğunu doğrulayın.
     // 5. pop up i kabul edin

     // Yine ayni class da baska test methodu olusturun
     // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
     // 2.  CLICK ME of JavaScript Confirm Box i  TIKLAYIN
     // 3.  pop up text i alın
     // 4. Mesajın "Press a button!" olduğunu doğrulayın
     // 5. Açılır pencereyi kapat
     // 6. pop up i iptal edin,
     // 7. "You pressed Cancel!" yazisinin goruntulendigini dogrulayin
     // 8. alert1'e göre dependsOnMethods kullanın
 */


    @Test
    public void alert1(){
       SoftAssert softAssert=new SoftAssert();
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.findElement(By.id("button1")).click();
        String alertText=driver.switchTo().alert().getText();
        String expectedMessage="I am an alert box!";
        softAssert.assertEquals(alertText,expectedMessage);
        driver.switchTo().alert().accept();
        softAssert.assertAll();
    }

    @Test(dependsOnMethods="alert1")
    public void alert2(){
        SoftAssert softAssert=new SoftAssert();
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.findElement(By.id("button4")).click();
        Alert alert=driver.switchTo().alert();
        String actualPopupText=alert.getText();
        String expectedMessage="Press a button!";
        alert.dismiss();
        softAssert.assertEquals(actualPopupText,expectedMessage,"2. popup mesaji hatali");
        WebElement actualCancelTextElement=driver.findElement(By.xpath("//p[@id='confirm-alert-text']"));
        softAssert.assertTrue(actualCancelTextElement.isDisplayed());
        softAssert.assertAll();
    }




}
