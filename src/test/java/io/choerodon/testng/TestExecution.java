package io.choerodon.testng;

import org.testng.TestNG;

import java.net.URL;
import java.net.URLDecoder;


/**
 * 此类用于jar包运行
 *
 * @author dinghuang123@gmail.com
 * @since 2019/1/18
 */
public class TestExecution {

    public static void main(String[] args) {
        URL url = TestExecution.class.getProtectionDomain().getCodeSource().getLocation();
        String filePath = null;
        try {
            // 转化为utf-8编码
            filePath = URLDecoder.decode(url.getPath(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 可执行jar包运行的结果里包含".jar"
        System.out.println("jar location:" + filePath);
        TestNG testNG = new TestNG();
        testNG.setTestJar(filePath);
        // 默认testng.xml
        testNG.setXmlPathInJar("testng.xml");
        testNG.run();
    }
}
