package io.choerodon.testng.config.utils;

import org.testng.Reporter;

/**
 * @author shinan.chen
 * @since 2019/1/21
 */
public class ReporterUtil {
    public static void inputData(String input){
        Reporter.log("[INPUT] "+input,true);
    }

    public static void expectData(String expect){
        Reporter.log("[EXPECT] "+expect,true);
    }
}
