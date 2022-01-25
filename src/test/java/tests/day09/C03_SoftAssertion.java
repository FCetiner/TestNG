package tests.day09;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion {


    @Test
    public void test01(){
        int a=10;
        int b=20;
        int c=30;

        SoftAssert softAssert= new SoftAssert();

        softAssert.assertEquals(a,b,"1. test basarisiz");   //failed
        softAssert.assertTrue(a>b,"2. test basarisiz"); //failed
        softAssert.assertTrue(a<c); //passed
        softAssert.assertTrue(c>b); //passed
        softAssert.assertTrue(c<a,"3. test basarisiz"); //failed

        //assertAll demezdek class calisir ve passed yazar , cunku aslinda raporlama yapmaz kodlar calismis olur
        //softassert te hata mesaji yazmak onemli hangi assertler fail bunu anlamak icin
        softAssert.assertAll();
        System.out.println("Assertlerde hata varsa bu satir calismaz");

    }
}
