package io.choerodon.testng.demo.selenuim;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.choerodon.testng.config.domain.TestConfigure;
import io.choerodon.testng.config.utils.ReporterUtil;
import io.choerodon.testng.config.utils.TestConfigureParse;

@Test
public class ChromeTest {

    private TestConfigure testConfigure = TestConfigureParse.getConfigure();

    @BeforeClass
    public void setUp() {
    }

    @Test(description = "login")
    public void login() {
        WebDriver driver = null;

        try {
            driver = new RemoteWebDriver(new URL(testConfigure.getSeleniumURL()), new ChromeOptions());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.get(testConfigure.getApiGateway());
        driver.manage().window().setSize(new Dimension(1440, 877));

        ReporterUtil.inputData("登录名：" + testConfigure.getUsername() + "，" +
                "密码：" + testConfigure.getPassword());
        driver.findElement(By.id("username")).sendKeys(testConfigure.getUsername());
        driver.findElement(By.id("password")).sendKeys(testConfigure.getPassword());

        ReporterUtil.expectData("登陆成功");
        driver.findElement(By.cssSelector(".ant-btn")).click();
    }
}
