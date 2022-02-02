package tests.day00_selenium_homework_documents;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class Q11 extends TestBase {

    @Test
    public void test01(){
       // go to url :http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
       //get the first window clicking on click here button
        String firstWindowHandle=driver.getWindowHandle();
        WebElement clickHere=driver.findElement(By.xpath("//a[.='Click Here']"));
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",clickHere);
        //get all the window in the set
        Set<String> handleSet=driver.getWindowHandles();
       String secondWindowHandle="";
        for(String each:handleSet){
            if(!each.contains(firstWindowHandle)){
                secondWindowHandle=each;
            }
        }
        //switch to window
        driver.switchTo().window(secondWindowHandle);
       //input email id (somepne@gmail.com) and type something in that input
        WebElement emailAdressElement= driver.findElement(By.xpath("//input[@name='emailid']"));
        Faker faker=new Faker();
        emailAdressElement.sendKeys(faker.internet().emailAddress());
        //Clicking on the submit button
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //verify title as expected
        String actualTitle=driver.getTitle();
        String expectedTitle="Guru99 Bank Home Page";
        Assert.assertEquals(actualTitle,expectedTitle);
        //switch to first window
        driver.switchTo().window(firstWindowHandle);





    }






}
