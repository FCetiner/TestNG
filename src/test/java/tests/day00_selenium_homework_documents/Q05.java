package tests.day00_selenium_homework_documents;

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
import java.util.Set;

public class Q05 {
    WebDriver driver;
    String windowHandleDegeri1;
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
        windowHandleDegeri1=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void titleTest02(){
        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> windowHandleDegerleri=driver.getWindowHandles();
        String windowHandleDegeri2="";
        for(String each:windowHandleDegerleri){
            if(!each.equals(windowHandleDegeri1)){
                windowHandleDegeri2=each;
            }
        }

        driver.switchTo().window(windowHandleDegeri2);

        String actualTitle = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
        String expectedWord="New Window";
        Assert.assertEquals(actualTitle,expectedWord,"Second page Title test FAILED");
    }

    @Test(priority =3)
    public void textTest02() throws InterruptedException {
        // Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfadakiYaziElementi=driver.findElement(By.tagName("h3"));
        String expectedWord="New Window";
        Thread.sleep(5000);
        Assert.assertNotEquals(ikinciSayfadakiYaziElementi.getText(),expectedWord,"Second page Text Test FAILED");
    }

    @Test(priority =4)
    public void titleTest03() throws InterruptedException {
        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
       driver.switchTo().window(windowHandleDegeri1);

        String actualTitle=driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }






}
