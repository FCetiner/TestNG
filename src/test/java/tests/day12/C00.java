package tests.day12;

public class C00 {
    //1-Handling Windows: Eger otomasyon sirasindan birdenn fazla pencere veya tab aciliyorsa,
    // pencereler veya tablar arasinda driver'imizi gezdirmemiz gerekir.
    //2-Eger selenium 4 ile yeni gelen switchTo().newWindow() method'unu kullanirsak,
    // driver otomatik olarak yeni acilan window'a gecer, ancak bir linke tiklayarak yeni bir sayfa aciliyorsa,
    // driver eski sayfada kalir.
    //3-Eger otomasyon sirasinda birden fazla pencere aciliyorsa, kullandigimiz her sayfada
    // sayfanin window handle degerini String bir degiskene atamamizda fayda vardir.
    // Testin ilerleyen asamalarinda eski pencereye donmek istersek,
    // kaydettigimizbu window handle degerini kullaniriz.
    //4-Eger bizim driver'imiza actirdigimiz ama link ile acilan bir pencere olursa:
    //  -ilk once bir set olusturup, getWindowHandles() method'u ile acik olan tum sayfalarin
    //  window handle degerlerini bu Set'e store(kayit) ederiz
    //  -olusturdugumuz Set'in icerisinde daha once bulundugumuz ve woindow handle degerlerini aldigimiz
    //  sayfa(lar)in window handle degeri ve son gectigimiz ama window handle degerini bilmedigimiz
    //  sayfanin window handle degeri bulunur
    //  -Set'teki window handle degerlerini for-each loop ile control edersek, onceki sayfalarin
    //  window handle degerlerine esit olmayan, yeni sayfanin window handle degeridir.
    //  -Buldugumuz bu window handle degerini kullanarak yeni sayfaya gecis yapabiliriz
}
