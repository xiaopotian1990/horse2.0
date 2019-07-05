package com.xiaopotian.horse.common.log.data;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ==========================================
 *
 * @author : 小破天
 * @date : 2019/7/5 19:13
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Data
public class SysLogModel implements Serializable {
    private static final long serialVersionUID=1L;

    /**
     * 编号
     */
    private Long id;
    /**
     * 日志类型
     */
    @NotBlank(message = "日志类型不能为空")
    private String type;
    /**
     * 日志标题
     */
    @NotBlank(message = "日志标题不能为空")
    private String title;
    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 操作IP地址
     */
    private String remoteAddr;
    /**
     * 用户代理
     */
    private String userAgent;
    /**
     * 请求URI
     */
    private String requestUri;
    /**
     * 操作方式
     */
    private String method;
    /**
     * 操作提交的数据
     */
    private String params;
    /**
     * 执行时间
     */
    private Long time;

    /**
     * 异常信息
     */
    private String exception;

    /**
     * 服务ID
     */
    private String serviceId;

    /**
     * 删除标记
     */
    private String delFlag;
}
