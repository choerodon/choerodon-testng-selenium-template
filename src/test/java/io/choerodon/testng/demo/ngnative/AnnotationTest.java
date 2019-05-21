package io.choerodon.testng.demo.ngnative;

import org.testng.annotations.*;

/**
 * @author shinan.chen
 * @since 2019/1/10
 */
public class AnnotationTest {

    @DataProvider(name = "dataProvider")
    public Object[][] dataProvider1() {
        return new Object[][]{
                {"Cedric", new Integer(36)},
                {"Anne", new Integer(37)},
                {"Jay", new Integer(30)},
                {"Chen", new Integer(25)},
        };
    }

    /**
     * 先后顺序
     */
    @Test(dependsOnMethods = "dataProviderTest")
    public void dependsOnMethodsTest() {
//        assert "A".equals("B");
        System.out.println("dependsOnMethodsTest");
    }

    @Test(dataProvider = "dataProvider")
    public void dataProviderTest(String n1, Integer n2) {
        System.out.println(n1 + " " + n2);
    }

    @BeforeSuite
    public void beforeSuiteTest() {
        System.out.println("AnnotationTest:beforeSuiteTest1");
    }

    @AfterSuite
    public void afterSuiteTest() {
        System.out.println("AnnotationTest:afterSuiteTest");
    }

    @BeforeGroups(groups = "linux")
    public void beforeGroupsTest() {
        System.out.println("AnnotationTest:beforeGroupsTest");
    }

    @AfterGroups(groups = "linux")
    public void afterGroupsTest() {
        System.out.println("AnnotationTest:afterGroupsTest");
    }

    @BeforeClass
    public void beforeClassTest() {
        System.out.println("AnnotationTest:beforeClassTest");
    }

    @AfterClass
    public void afterClassTest() {
        System.out.println("AnnotationTest:afterClassTest");
    }

    @BeforeMethod
    public void beforeMethodTest() {
        System.out.println("AnnotationTest:beforeMethodTest");
    }

    @AfterMethod
    public void afterMethodTest() {
        System.out.println("AnnotationTest:afterMethodTest");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("AnnotationTest:beforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AnnotationTest:afterTest");
    }
}
