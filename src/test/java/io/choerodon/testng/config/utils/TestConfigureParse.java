package io.choerodon.testng.config.utils;

import io.choerodon.testng.config.domain.TestConfigure;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URL;

/**
 * @author dinghuang123@gmail.com
 * @since 2019/1/17
 */
public class TestConfigureParse {

    private static TestConfigure testConfigure = null;
    private static final String FILE_NAME = "configuration.yaml";

    private TestConfigureParse() {
    }

    public static TestConfigure getConfigure() {
        synchronized (TestConfigure.class) {
            if (testConfigure != null) {
                return testConfigure;
            } else {
                //读取yaml
                Yaml yaml = new Yaml();
                URL url = TestConfigureParse.class.getClassLoader().getResource(FILE_NAME);
                if (url == null) {
                    throw new IllegalArgumentException("The configuration file configure.yaml could not be found");
                } else {
                    try {
                        String filePath = url.getPath();
                        File file = new File(filePath);
                        if (file.exists()) {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            testConfigure = yaml.loadAs(fileInputStream, TestConfigure.class);
                        } else {
                            //jar包中读取
                            InputStream inputStream = TestConfigureParse.class.getClassLoader().getResourceAsStream(FILE_NAME);
                            testConfigure = yaml.loadAs(inputStream, TestConfigure.class);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("The configuration file configure.yaml could not be found" + e);
                    }
                }
                //读取环境变量
                for (Field field : TestConfigure.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    String envValue = System.getenv(StringUtils.upperCase(fieldName));
                    if (envValue != null) {
                        try {
                            field.set(testConfigure, envValue);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return testConfigure;
            }
        }
    }
}
