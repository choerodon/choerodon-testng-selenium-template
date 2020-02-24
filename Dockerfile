FROM registry.cn-hangzhou.aliyuncs.com/choerodon-tools/javabase:0.8.0
COPY app-tests.jar /{{service.code}}.jar
COPY run.sh /run.sh
ENTRYPOINT ["/run.sh"]