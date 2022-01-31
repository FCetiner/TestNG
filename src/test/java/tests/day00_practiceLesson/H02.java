package tests.day00_practiceLesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class H02 {


    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        Thread.sleep(1000);
        //    accept Alert(I am an alert box!) and print alert on console
        String alertMessage=driver.switchTo().alert().getText();
        System.out.println("alertMessage = " + alertMessage);
        driver.switchTo().alert().accept();
        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        //    cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();
        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();
        //    finally print on console this message "Hello TechproEducation How are you today"
        String message=driver.findElement(By.id("demo1")).getText();
        System.out.println("message = " + message);
    }

    @AfterClass
    public void teardown(){
        driver.close();
    }
}
