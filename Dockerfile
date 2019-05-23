FROM registry.cn-hangzhou.aliyuncs.com/choerodon-tools/javabase:0.7.1
COPY app-tests.jar /{{service.code}}.jar
COPY run.sh /run.sh
ENTRYPOINT ["/run.sh"]