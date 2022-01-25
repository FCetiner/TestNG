package tests.day08;

import org.testng.annotations.Test;

public class C01_Priority {


    @Test(priority=5)
    public void youtubeTest(){
        System.out.println("Youtube testi calisti");
    }
    @Test(priority=8)
    public void amazonTest(){
        System.out.println("Amazon testi calisti");
    }
    @Test       //priority atanmazsa default deger=0
    public void bestbuyTest(){
        System.out.println("BestBuy testi calisti");
    }

    //priority yoksa default  0 degerler arasinda harfsirasi yapar




}
