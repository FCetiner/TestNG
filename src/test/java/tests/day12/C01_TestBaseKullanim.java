package tests.day12;

import org.testng.annotations.Test;
import tests.day10.C01_Allerts;

public class C01_TestBaseKullanim {


    @Test
    public void test01(){
        //projeniz icerisindeki herhangi bir classdan obje olusturabilir ve
        //o obje sayesinde ait oldugu class'daki tum veriable ve methodlara
        //access modifier izin verdigi muddetce ulasabilirim
        C01_Allerts obj=new C01_Allerts();

        //eger proje kapsaminda bir class'dan obje olsuturulmasini engellemek isterseniz
        //1- o classin constructor ini private yapabiliriz
        //2- classin kendisini abstract yapabiliriz
        //1. method cok tercih edilmez cunku oop konsepte uymaz(cok sinirli sayida kullanimi vardir)
        //2. methodu kullanabiliriz, boylece o classdaki abstract olmayan (concrete) methodlari override etmek
        //mecburiyeti olmadan kullanabiliriz ama obje olusturamayiz

        //ornegin biz testBase classimizi abstract yaptigimizdan obje olusturamayiz ama child classlardan testBase deki
        //setup ve teardown methodlarini kullanabiliriz
    }
}
