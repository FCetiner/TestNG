package tests.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JavaScriptExecutorClick extends TestBase {

    //amazon.com gidin
    //sell linkine JSExecutor ile tiklayalim
    //ilgili sayfaya gittigimizi test edelim

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");

        //1. adim JsExecutor objesi olsuturalim ve driveri cast edelim
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        //2. ilgili webelementi locate edecegiz
        WebElement sellElement=driver.findElement(By.xpath("//a[normalize-space()='Sell']"));

        //3. adim ilgili script ve argument(bizim web Elementimiz) ile objemiz uzerinden
        //executeScript methodunu calistiralim

        jse.executeScript("arguments[0].click();",sellElement);
        Thread.sleep(3000);
    }
}
