package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_IFrame {
    WebDriver driver;
    //● Bir class olusturun: IframeTest
    @BeforeClass
    public void set_up(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void iframeTest(){
        //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //   ● Bir metod olusturun: iframeTest
        //        ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
        WebElement istenenYaziElementi=driver.findElement(By.tagName("h3"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(istenenYaziElementi.isEnabled(),"iframe yazisi gorunmuyor");
        System.out.println(istenenYaziElementi.getText());
        //        ○ Text Box’a “Merhaba Dunya!” yazin.


        //Yazi yazmak istedigimiz text kutusu iframein içinde oldugundan direkt ulasamıyoruz
        //once iframe i locate edip onun icine switch yapmaliyiz
        WebElement iFrame=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);
        WebElement textBox=driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Hello World");
        //        ○ TextBox’in altinda bulunan “Elemental Selenium” linkini tiklayin t
        //Yukarida iFramein icine switch yaptigimizdan yeniden disari cikmak istedigimizde ana sayfaya donmeliyiz
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        //Yeni sayfada "Elemental Selenium" textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.
        //sponsored yazisi yeni sayfada oldugundan ve drver eski sayfada kaldigindan yaziyi locate edemedik
        WebElement sponsoredYazisiElementi=driver.findElement(By.xpath("//p[text()='Sponsored by ']"));
        softAssert.assertTrue(sponsoredYazisiElementi.isDisplayed(),"sponsored yazisi gorunmuyor");

   softAssert.assertAll();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
    }
