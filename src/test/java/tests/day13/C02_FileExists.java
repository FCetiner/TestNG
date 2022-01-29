package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


public class C02_FileExists {

    @Test
    public void test01(){
        System.out.println(System.getProperty("user.home")); //C:\Users\Ferhat
        // C:\Users\Ferhat\Desktop\deneme

        //dinamik olarak masaustundeki deneme klasorunun pathini yazmak istersem

        String path=System.getProperty("user.home")+"\\Desktop\\deneme\\selenium.txt";
        System.out.println(path);

        System.out.println(System.getProperty("user.dir   :"+"user.dir"));
        //Masa ustunde deneme klasoru icerisinde selenium.txt isminde bir dosya oldugunu test edin
        //********** masaustunde deneme klasorum ve icinde seleniım.txt olmazsa calismaz
        //1- once bu dosyaya ulasmak icin gerekli dinamik path olusturulmalı
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\deneme\\selenium.txt";

        System.out.println(Files.exists(Paths.get(dosyaYolu))); //true orada dosya var

        //projemizde pom.xml oldugunu test edin
        //C:\Users\Ferhat\IdeaProjects\com.TestNGBatch44\pom.xml

        System.out.println(System.getProperty("user.dir")); //projemizin yolunu verir
        //C:\Users\Ferhat\IdeaProjects\com.TestNGBatch44 aradaki fark pom.xml

        String pomPath=System.getProperty("user.dir")+"\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(pomPath)));
    }
}
