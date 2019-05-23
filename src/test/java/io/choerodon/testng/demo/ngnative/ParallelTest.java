package io.choerodon.testng.demo.ngnative;

import org.testng.annotations.Test;

/**
 * @author shinan.chen
 * @since 2019/1/10
 */
public class ParallelTest {

    @Test
    public void parallelTest1() {
        System.out.println(1);
    }

    @Test
    public void parallelTest2() {
        System.out.println(2);
    }

    @Test
    public void parallelTest3() {
        System.out.println(3);
    }
}
