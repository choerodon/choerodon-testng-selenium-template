#!/bin/sh
java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap $JAVA_OPTS -jar /{{service.code}}.jar
cd test-output
tar -czvf testng-results.tar.gz testng-results.xml
curl -v -X POST ${RESULTGATEWAY}/test/v1/automation/import/report/testng?releaseName=${RELEASENAME} -F "file=@testng-results.tar.gz"
curl -s http://localhost:4444/extra/LifecycleServlet\?action\=shutdown