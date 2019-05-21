package io.choerodon.testng.demo.selenuim;

import java.net.MalformedURLException;
import java.net.URL;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.choerodon.testng.config.domain.TestConfigure;
import io.choerodon.testng.config.utils.TestConfigureParse;

@Test
public class ChromeTest {

    private TestConfigure testConfigure = TestConfigureParse.getConfigure();

    @BeforeClass
    public void setUp() {
    }

//    @Test(description = "test")
//    public void test() {
//        try {
//            WebDriverManager.iedriver().setup();
//            WebDriver driver = new InternetExplorerDriver();
//            driver.get("https://www.baidu.com/");
//            driver.findElement(By.cssSelector("input#kw")).sendKeys("java");
//            driver.findElement(By.cssSelector("input#su")).click();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("以下是广告：");
//            driver.findElements(By.cssSelector("h3[class ^='t ']")).forEach(x -> {
//                String className = x.getAttribute("class");
//                if (className.split(" ").length == 3 && className.length() == 15) {
//                    System.out.println(x.getText());
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        } catch (Exception e) {
//            System.out.println(e);
//        }
////        driver.quit();
//    }

    @Test(description = "remote")
    public void remote() {
        WebDriver driver = null;

        try {
            driver = new RemoteWebDriver(new URL(testConfigure.getSeleniumURL()), new ChromeOptions());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("https://www.baidu.com/");
        driver.findElement(By.cssSelector("input#kw")).sendKeys("java");
        driver.findElement(By.cssSelector("input#su")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("以下是广告：");
        driver.findElements(By.cssSelector("h3[class ^='t ']")).forEach(x -> {
            String className = x.getAttribute("class");
            if (className.split(" ").length == 3 && className.length() == 15) {
                System.out.println(x.getText());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
