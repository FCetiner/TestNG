package tests.day00_practiceLesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class H01  {

    //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
    //maximize the window
//click on action dialog button
    //if need use explicitly wait
//click on the ok button
//accept the iframe message
   WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
     //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        driver.findElement(By.xpath("//button[@id='action']")).click();
        driver.findElement(By.id("dialog-mycodemyway-action")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @AfterClass
    public void teardown(){
        driver.close();
    }
}
