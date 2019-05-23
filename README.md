# choerodon-testng-selenium-template

This is a choerodon testng-selenium template，for api test

## TestNg Configuration

* src/test/resources/testng.xml: TestNg main configuration
* src/test/resources/suite: TestNg more suite source

## Project/Environment Configuration

* resultGateway: TestNg result xml return save location gateway
* apiGateWay: selenium test execute location gateway
* projectId: selenium test execute projectId
* loginName: selenium test execute loginName
* password: selenium test execute password
* seleniumURL: selenium web driver URL

## Programming advice

This template use rest-assured framework for api test，before request send to set expect，then result will catch 'expect value', it also can catch request params as 'test value'.
```$xslt
WebDriver driver = null;

try {
    driver = new RemoteWebDriver(new URL(...), new ChromeOptions());
} catch (MalformedURLException e) {
    e.printStackTrace();
}

driver.get(...);
```

If you need custom 'expect value' and 'test value', you can set log before request, it will cover the default.
```$xslt
//测试数据
ReporterUtil.inputData("输入参数");
//预期结果
ReporterUtil.expectData("预期结果");
```