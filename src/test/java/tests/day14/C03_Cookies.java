package tests.day14;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C03_Cookies extends TestBase {
    
    //Yeni bir class olusturun : cookiesAutomation
    
    
    @Test
    public void textTest01(){
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet= driver.manage().getCookies();
        int sayac=1;
        for(Cookie each:cookiesSet){
            System.out.println(sayac+". cookie :" + each);
            sayac++;
        }
        
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSet.size()>5);
        //4- ismi "i18n-prefs" olan cookie degerinin USD oldugunu test edin
        Cookie cookiei18n= driver.manage().getCookieNamed("i18n-prefs");
        System.out.println("cookiei18n = " + cookiei18n);
        Assert.assertTrue(driver.manage().getCookieNamed("i18n-prefs").getValue().equals("USD"));
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie myCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(myCookie);

        Set<Cookie> cookiesSet2= driver.manage().getCookies();
        int count=1;
        for(Cookie each:cookiesSet2){
            System.out.println(count+". cookie :" + each);
            count++;
        }

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(cookiesSet2.contains(myCookie));
        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");

        Set<Cookie> cookiesSet3= driver.manage().getCookies();
        count=1;
        for(Cookie each:cookiesSet3){
            System.out.println(count+". cookie :" + each);
            count++;
        }
        Assert.assertFalse(cookiesSet3.contains(driver.manage().getCookieNamed("skin")));
        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();

        Set<Cookie> cookieSet4=driver.manage().getCookies();
        Assert.assertTrue(cookieSet4.size()==0);
    }
}
