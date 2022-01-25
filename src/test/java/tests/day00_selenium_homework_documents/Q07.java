package tests.day00_selenium_homework_documents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Q07 {
    WebDriver driver;

    // 4 TEST METODU OLUSTURUN,oncelik vererek sirasiyla
    // https://www.n11.com/ SAYFASINA GiDİN.
    // https://www.gittigidiyor.com/ SAYFASINA GiDiN
    // https://getir.com/ SAYFASINA GiDiN
    // https://www.sahibinden.com/ SAYFASINA GiDiN

    @BeforeClass
    public void set_up(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void n11Test(){
        driver.get("https://www.n11.com/");
    }
    @Test(priority = 2)
    public void gittigidiyorTest(){
        driver.get("https://www.gittigidiyor.com/");
    }
    @Test(priority = 3)
    public void getirTest(){
        driver.get("https://getir.com/");
    }
    @Test(priority = 4)
    public void sahibindenTest(){
        driver.get("https://www.sahibinden.com/");
    }
    @AfterClass
    public void teardown(){
        driver.close();
    }

}
