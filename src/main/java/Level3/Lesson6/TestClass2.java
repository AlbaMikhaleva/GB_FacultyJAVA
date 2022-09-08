package Level3.Lesson6;

import org.testng.annotations.AfterSuite;

public class TestClass2 {

    @AfterSuite()
    public static void beforeSuite() {
        System.out.println("BEFORE SUITE");
    }

    @Test(prior = 1)
    public static void a() {
        System.out.println("TEST 1");
    }

    @Test(prior = 3)
    public static void b() {
        System.out.println("TEST 3");
    }

    @Test(prior = 0)
    public static void c() {
        System.out.println("TEST 0");
    }

    @Test(prior = 2)
    public static void d() {
        System.out.println("TEST 2");
    }

    @AfterSuite()
    public static void afterSuite() {
        System.out.println("AFTER SUITE");
    }

}
