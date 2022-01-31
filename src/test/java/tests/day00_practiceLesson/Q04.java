package tests.day00_practiceLesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q04 {
    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     *     T1 : Choose price low to high
     *     T2 : Verify item prices are sorted from low to high with soft Assert
     */
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @BeforeMethod
    public void siteyeGir(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }


    @Test
    public void sauceDemoTest01(){
    WebElement dropDownElementi = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
   Select select=new Select(dropDownElementi);
   select.selectByVisibleText("Price (low to high)");

   String expected="PRICE (LOW TO HIGH)";
   String actuel=driver.findElement(By.className("active_option")).getText();
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(actuel,expected,"Fiyatlar istenildigi gibi siralanmamistir");

        softAssert.assertAll();
    }

    @Test
    public void sauceDemoTest02(){
        WebElement dropDownElementi = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select=new Select(dropDownElementi);
        select.selectByVisibleText("Price (low to high)");

        List<WebElement> fiyatlar=driver.findElements(By.className("inventory_item_price"));
        ArrayList<Double> fiyatlarDouble=new ArrayList<>();

        for (WebElement fiyat:fiyatlar) {
            String fiyatStr=fiyat.getText().replaceAll("\\D","");

       fiyatlarDouble.add(Double.parseDouble(fiyatStr));
        }
        ArrayList<Double> kontrolist=new ArrayList<>(fiyatlarDouble);
        Collections.sort(kontrolist);

        Assert.assertEquals(kontrolist,fiyatlarDouble);
    }
}
