package io.choerodon.testng.demo.ngnative;

import org.testng.annotations.Test;

public class FactoryTestIntance {
    private int m_numberOfTimes;

    public FactoryTestIntance(int numberOfTimes) {
        m_numberOfTimes = numberOfTimes;
    }

    @Test
    public void testServer() {
        for (int i = 0; i < m_numberOfTimes; i++) {
            // access the web page
        }
    }
}