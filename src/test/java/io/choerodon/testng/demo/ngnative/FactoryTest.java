package io.choerodon.testng.demo.ngnative;

import org.testng.annotations.Factory;

/**
 * @author shinan.chen
 * @since 2019/1/10
 */
public class FactoryTest {

    @Factory
    public Object[] createInstances() {
        Object[] result = new Object[10];
        for (int i = 0; i < 10; i++) {
            result[i] = new FactoryTestIntance(i * 10);
        }
        return result;
    }
}
