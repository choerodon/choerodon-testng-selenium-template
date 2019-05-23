package io.choerodon.testng.demo.ngnative;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

/**
 * @author shinan.chen
 * @since 2019/1/8
 */
public class UnitTest {
    @Test
    public void isEmpty() {
        System.out.println("isEmpty");
    }

    @Test
    public void trim() {
        assert "foo".equals(StringUtils.trim("  foo   "));
    }
}
