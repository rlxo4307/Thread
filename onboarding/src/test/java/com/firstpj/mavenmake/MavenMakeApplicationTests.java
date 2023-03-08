package com.firstpj.mavenmake;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MavenMakeApplicationTests {
    @Before
    public void Before() {
        int a = 0;
        System.out.println("Before" + a);
    }
//    @After
//    public void After() {
//        System.out.println("After");
//    }
    @Test
    void contextLoads1() {
        int a = 1;
        System.out.println(a);
    }
    @Test
    void contextLoads2() {
        int a = 2;
        System.out.println(a);
    }
    @Test
    void contextLoads3() {
        int a = 3;
        System.out.println(a);
    }

//    @BeforeClass
//    public static void reeatlastd() {
//        System.out.println("BeforeClass");
//    }
    @BeforeAll
    static void BeforeAll1() {
        int a = -1;
        System.out.println("BeforeAll1" + a);
    }
    @BeforeAll
    static void BeforeAll2() {
        int a = -2;
        System.out.println("BeforeAll2" + a);
    }
//    @AfterAll
//    static void z() {
//        System.out.println("AfterAll");
//    }
//    @AfterAll
//    static void reeatlast12() {
//        System.out.println("AfterAll2");
//    }


//    @AfterClass
//    public static void AfterClass() {
//        System.out.println("AfterClass");
//    }
//    @AfterClass
//    public static void AfterClass2() {
//        System.out.println("AfterClass2");
//    }

}
