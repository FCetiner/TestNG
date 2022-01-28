package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_DragAndDrop extends TestBase {


    @Test
    public void test01 () throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragElementi=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropElementi=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragElementi,dropElementi).perform();
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Thread.sleep(3000);
        String actualDropYazisi=dropElementi.getText();
        String expectedDroppedYazisi="Dropped";

        Assert.assertEquals(actualDropYazisi,expectedDroppedYazisi);
    }


}
