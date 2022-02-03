package tests.day00_selenium_homework_documents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class Q11_Answer extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("http://demo.guru99.com/popup.php");
        //  get the first window
        String firstWin = driver.getWindowHandle();
        Thread.sleep(2000);
        //  clicking on click here button
        WebElement buttonClickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        Thread.sleep(2000);
        buttonClickHere.click();
        Thread.sleep(2000);
        //  get all the window in the set
        Set<String> windowAllWindows =  driver.getWindowHandles();
        //  switch to window
        for(String window :windowAllWindows){
            driver.switchTo().window(window);
        }
        Thread.sleep(2000);
        //  input email id and type something in that input
        WebElement inputEmailID = driver.findElement(By.xpath("//input[@name='emailid']"));
        inputEmailID.sendKeys("somepne@gmail.com");
        Thread.sleep(2000);
        //   Clicking on the submit button
        WebElement buttonSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
        buttonSubmit.click();
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());
        //http://demo.guru99.com/access_popup.php?uid=mngr69964%20&%20pass=UvunusE%20&%20email=somepne@gmail.com
        //   verify title as expected
        try {
            Assert.assertEquals("Guru99 Bank Home Page", driver.getTitle());
            System.out.println("Title as expected "); //Title as expected
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Thread.sleep(2000);
        //   switch to first window    note : firstWin is coming from line 30
        driver.switchTo().window(firstWin);
        System.out.println(driver.getCurrentUrl()); //http://demo.guru99.com/popup.php
    }
}
