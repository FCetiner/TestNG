package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropDown {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    //dropdown menuler selectle baslar altinda optionlar vardir
    @Test
    public void dropdownTesti() throws InterruptedException {
      //Dropdown da var olan seceneklerden birini secmek icin
      // 1. adim Dropdown webelementini locate edip bir degiskene atiyoruz
      driver.get("https://www.amazon.com");
      WebElement dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

      //2. adim Select class'ından bir obje olusturalim
        //ve parametre olarak locate ettigimiz Webelementi yazalim

        Select select=new Select(dropdownElementi);
        //3. adim select objesini kullanarak, Selct classinda var olan 3 secim methodundan
        //istedigimizi kullanarak dropdownda var olan optionlardan birini secebiliriz
        //secim yapmamiza yardim eden bu 3 method void'dir dolayisi ile bize birsey dondurmez
        select.selectByIndex(3);    //sadece secim yapar bize yazdirma islemi yapmaz

        //eger sectigimiz option degerini yazdirmak istersek
        System.out.println(select.getFirstSelectedOption());

        Thread.sleep(3000);
        select.selectByVisibleText("Deals");

        select.selectByValue("search-alias=beauty-intl-ship");

        List<WebElement> optionList=select.getOptions();

        for(WebElement each : optionList){
            System.out.println(each.getText());
        }

    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
