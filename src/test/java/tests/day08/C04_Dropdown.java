package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown {
    WebDriver driver;
    WebElement dropdownElementi;
    Select select;

    // Bir class oluşturun: C3_DropDownAmazon
    // https://www.amazon.com/ adresine gidin.
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }


    @Test
    public void test01(){
        //- Test 1
        //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        driver.get("https://www.amazon.com/");
        dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropdownElementi);

        List<WebElement> optionListesi=select.getOptions();
        int actualOptionSayisi=optionListesi.size();
        int expectedOptionSayisi=45;
        Assert.assertEquals(actualOptionSayisi,expectedOptionSayisi,"Option sayisi 45 e esit degil");
    }

    @Test
    public void test02(){
        //-Test 2
        //    1. Kategori menusunden Books secenegini  secin
        select.selectByVisibleText("Books");
        //    2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
        //    3. Bulunan sonuc sayisini yazdirin
        WebElement sonucElement=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucCumle=sonucElement.getText();
        String sonucKelimeler[]=sonucCumle.split(" ");
        String sonuc=sonucKelimeler[3].replaceAll("\\D","");
        int sonucInt= Integer.parseInt(sonuc);
        System.out.println(sonucInt);
        //    4. Sonucun Java kelimesini icerdigini test edin
       String arananKelime="Java";
       boolean iceriyorMu=sonucCumle.contains(arananKelime);
        Assert.assertTrue(iceriyorMu,"Arama java sonucunu icermiyor");


    }
    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
