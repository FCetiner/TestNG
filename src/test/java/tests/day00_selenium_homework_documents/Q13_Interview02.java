package tests.day00_selenium_homework_documents;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Q13_Interview02 extends TestBase {

    @Test
    public  void test() throws InterruptedException {
        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
// 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
// (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        List<WebElement> urunlerListesiWebElement=driver.findElements(By.xpath("//p[@class='shelf-item__title']"));
        urunYazdir(urunlerListesiWebElement);
// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        urunAdlariniListeEkle(urunlerListesiWebElement);
// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
// (Her ürün 1 defadan fazla eklenemez!)
         rastgeleBesUrunSecSepeteEkleveYazdir(driver);
// 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        String cartTotalPriceString=driver.findElement(By.xpath("//p[@class='sub-price__val']")).getText();
        int actualCartTotalPrice=Integer.parseInt(cartTotalPriceString.replaceAll("\\D",""));
        int expectedRastgeleSecilenUrunlerinFiyatToplami=secilenOgelerinFiyatiniTopla(driver);
        Assert.assertEquals(actualCartTotalPrice,expectedRastgeleSecilenUrunlerinFiyatToplami);
// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
        System.out.println("Test Pass");
// 7.Checkout'a tıklayın
        driver.findElement(By.xpath("//div[@class='buy-btn']")).click();
    }

    private int secilenOgelerinFiyatiniTopla(WebDriver driver) {
        int toplam=0;
        List<WebElement> pricesOfTheProductInTheCart=driver.findElements(By.xpath("//div[@class='float-cart float-cart--open']//div[@class='shelf-item__price']"));
        for (WebElement each:pricesOfTheProductInTheCart) {
          toplam+=Integer.parseInt(each.getText().replaceAll("\\D",""));
        }
   return toplam;
    }

    private void rastgeleBesUrunSecSepeteEkleveYazdir(WebDriver driver) throws InterruptedException {
        Random random=new Random();
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        List<WebElement> addToChartWebElementList=driver.findElements(By.xpath("//div[@class='shelf-item__buy-btn']"));
        int count=0;
        while (count<5){
            int randomNum=random.nextInt(addToChartWebElementList.size());
            System.out.println("randomNum = " + randomNum);
            jse.executeScript("arguments[0].scrollIntoView();",addToChartWebElementList.get(randomNum));
            addToChartWebElementList.get(randomNum).click();
            Thread.sleep(1000);
            WebElement cartCloseButton=driver.findElement(By.xpath("//div[@class='float-cart__close-btn']"));
            cartCloseButton.click();
          addToChartWebElementList.remove(randomNum);
            count++;
        }
        WebElement cartOpenButton=driver.findElement(By.xpath("//span[@class='bag bag--float-cart-closed']"));
        cartOpenButton.click();
        List <WebElement> productsInTheChart=driver.findElements(By.xpath("//p[@class='title']"));
        productsInTheChart.stream().forEach(t-> System.out.println(t.getText()));

    }


    private void urunAdlariniListeEkle(List<WebElement> urunlerListesiWebElement) {
        List<String> urunListesiList=new ArrayList<>();
        for (int i=0;i<urunlerListesiWebElement.size();i++){
                urunListesiList.add(urunlerListesiWebElement.get(i).getText());
        }
    }

    private void urunYazdir(List<WebElement> urunlerListesiWebElement) {
        for(int i=0;i<urunlerListesiWebElement.size();i++){
            System.out.println(i + ". urun = " + urunlerListesiWebElement.get(i).getText());
        }
    }


}
