package io.choerodon.testng.demo.ngnative;

import org.testng.annotations.*;

/**
 * @author shinan.chen
 * @since 2019/1/10
 */
public class GroupTest {

    @Test(groups = {"windows", "linux"})
    public void groupTest1() {
        System.out.println("groupTest1");
    }

    @Test(groups = {"windows"})
    public void groupTest2() {
        System.out.println("groupTest2");
    }

    @Parameters("db")
    @Test(groups = {"linux"})
    public void groupTest3(@Optional("oracle") String db) {
        System.out.println("123123");
        assert db.equals("mysql");
    }

    @BeforeGroups
    public void beforeGroupsTest() {
        System.out.println("GroupTest:beforeGroupsTest");
    }

    @AfterGroups(value = "linux")
    public void afterGroupsTest() {
        System.out.println("GroupTest:afterGroupsTest");
    }
}
