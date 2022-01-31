package tests.day14;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {

    @Test
    public void facebookKayitTest(){
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");
        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        WebElement isimElementi=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();

        actions.
                //“firstName” giris kutusuna bir isim yazin
                sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).
                //“surname” giris kutusuna bir soyisim yazin
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                //“email” giris kutusuna bir email yazin
                sendKeys(email).
                sendKeys(Keys.TAB).
                //“email” onay kutusuna emaili tekrar yazin
                sendKeys(email).
                sendKeys(Keys.TAB).
                //Bir sifre girin
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                //Tarih icin gun secin
                sendKeys("15").
                sendKeys(Keys.TAB).
                //Tarih icin ay secin
                sendKeys("Ş").
                sendKeys(Keys.TAB).
                //Tarih icin yil secin
                sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                //Cinsiyeti secin
                sendKeys(Keys.ARROW_RIGHT).
                perform();
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement erkekSecimElementi =driver.findElement(By.xpath("//input[@value='2']"));
        WebElement kadinSecimElementi=driver.findElement(By.xpath("//input[@value='1']"));
        Assert.assertTrue(erkekSecimElementi.isSelected());
        Assert.assertFalse(kadinSecimElementi.isSelected());
        //Sayfayi kapatin
    }

}
