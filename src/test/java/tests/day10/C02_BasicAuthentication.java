package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_BasicAuthentication {
    WebDriver driver;
    //1- Bir class olusturun : BasicAuthentication

    @BeforeClass
    public void set_up(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void authenticationTest(){
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
      //  driver.get("https://the-internet.herokuapp.com/basic_auth");
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //    Html komutu : https://username:password@URL
        //    Username     : admin
        //    password      : admin

        //basic authentication isteyen web servisleri bize nasil ve hangi bilgilerle
        //authentication yapabilecegimiz bilgisini de vermek zorundadir
        //biz de bize tarif edilen yontem ile bire bir uygulayarak
        //istedigimiz webservise giris yapariz
     driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement congratMesajElementi=driver.findElement(By.tagName("p"));
        Assert.assertTrue(congratMesajElementi.isDisplayed());

    }

    @AfterClass
    public void teardown(){
        driver.close();
    }


}
