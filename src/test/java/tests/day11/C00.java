package tests.day11;

public class C00 {
    //1.Driver bizim elimiz, gozumuz gibidir. Onu nereye gonderirsek orda bizim adimiza istedigimiz islemleri yapar.
    //Ama bazen driver'i gonderdigimiz sayfa disina cikmamiz gerekebilir. (alert, iframe, tabs veya yeni pencere gibi..)
    //2.Driver'i gonderdigimiz sayfa disinda bir yerde islem yaptirmak istrersek driver.switchto().yeni ortam
    //3.switch.to() ile gittigimiz ortam alert ise
    //-Ok'e basmak icin .accept()
    //-cancel'e basmak icin .dismiss
    //-alert uzerinde var olan yaziyi almak icin .getText()
    //-alert'de varsa yazi gondermek icin .sendKeys() method'larina kullanabiliriz
    //4.switchTo() ile gittigimiz ortam iframe ise
    //-3 farkli yontem ile iframe'e grcis yapabiliriz
    //i- index
    //ii-id veya name(String)
    //iii-Webelement olarak gecis icin method kullanabiliriz
    //-bir defa iframe'e gecince tekrar o iframe'den cikmamiz gerekirse yine .switchTo() kullanmaliyiz
    //i-parentFrame : icinde oldugumuz iframe'den bir ust iframe'e cikar
    //ii- defaultContent : en ust seviyeye yani anasayfaya gecis yapar
    //eger sadece bir tane iframe varsa bu iki yontem ayni islemi yapmis olur
}
