package tests.day00_practiceLesson;

import org.testng.annotations.Test;

public class Q01 {
    /*
  ●TestNG (default ) olarak @Test methodları ni alfabetik sıraya gore run eder ..(Yukardan asagi degil)
  ●priority annotation Testlere öncelik vermek icin kullanilir, Kucuk olan Numara daha once calisir.
  priority:  TestNG testlerinde, testler konsola alfabetik sira ile yazdirilir.
    default degeri=0;
  enabled = false  methodu : Testi gormezden gelmek icin @Test in yanina    '(enabled = false)' fonksiyonunu kullaniriz.
 */

    @Test(priority = 3000)
    public void b(){
        System.out.println("b");
    }

    @Test(priority = 2001 , enabled = false)        // JUnit de @Ignore annotation karsiligi
    public void a(){
        System.out.println("a");
    }

    @Test(priority = 3000)
    public void c(){
        System.out.println("c");
    }

    @Test
    public void test1(){
        System.out.println("TEST1....");
    }
    @Test
    public void test2(){
        System.out.println("TEST2....");
    }
    @Test
    public void test3(){
        System.out.println("TEST3....");
    }
    @Test(enabled = false)
    public void test4(){
        System.out.println("TEST4....");
    }
    @Test(enabled = false)
    public void test5(){
        System.out.println("TEST5....");
    }
    @Test
    public void test6(){
        System.out.println("TEST6....");
    }
}
