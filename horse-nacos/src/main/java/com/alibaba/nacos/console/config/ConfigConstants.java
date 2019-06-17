package com.alibaba.nacos.console.config;

/**
 * ==========================================
 * 覆盖nacos 默认配置
 * @author : 小破天
 * @date : 2019/6/17 21:38
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
public interface ConfigConstants {
    /**
     * The System property name of  Standalone mode
     */
    String STANDALONE_MODE = "nacos.standalone";

    /**
     * tomcat 目录
     */
    String TOMCAT_DIR = "server.tomcat.basedir";

    /**
     * tomcat 日志配置
     */
    String TOMCAT_ACCESS_LOG = "server.tomcat.accesslog.enabled";
}
