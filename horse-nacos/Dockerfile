FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER 545926080@qq.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /horse-nacos

WORKDIR /horse-nacos

EXPOSE 8848

ADD ./horse-nacos/target/horse-nacos.jar ./


CMD sleep 20;java -Djava.security.egd=file:/dev/./urandom -jar horse-nacos.jar


