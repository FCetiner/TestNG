package tests.day00_selenium_homework_documents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q06 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @Test(priority=1)
    public void textTest01(){
        // Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    String text=driver.findElement(By.xpath("//div[@class='example']")).getText();
    String arananKelime="Opening a new window";
    Boolean iceriyorMu=text.contains(arananKelime);
    Assert.assertTrue(iceriyorMu,"Aranan Kelimeyi icermiyor");
    }

    @Test(priority=1)
    public void titleTest01(){
        // Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String title=driver.getTitle();
        String arananKelime="The Internet";
        Boolean iceriyorMu=title.contains(arananKelime);
        Assert.assertTrue(iceriyorMu,"Title aranan kelimeyi icermiyor");
    }

    @Test(priority = 2)
    public void clickHereButonTest() throws InterruptedException {
        // Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void titleTest02(){
        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualTitle=driver.getTitle();
        String expectedWord="New Window";
        Assert.assertEquals(actualTitle,expectedWord,"Title test FAILED");
    }

    @Test(priority =3)
    public void textTest02(){
        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualText=driver.findElement(By.xpath("//div[@class='example']")).getText();
        String expectedWord="New Window";
        Assert.assertEquals(actualText,expectedWord,"Text Test FAILED");
    }

    @Test(priority =4)
    public void titleTest03() throws InterruptedException {
        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.navigate().back();
        Thread.sleep(3000);
        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }






}
