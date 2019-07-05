package com.xiaopotian.horse.common.log.util;

import cn.hutool.core.util.URLUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import com.xiaopotian.horse.common.core.constant.CommonConstants;
import com.xiaopotian.horse.common.log.data.SysLogModel;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * ==========================================
 * 操作日志工具类
 *
 * @author : 小破天
 * @date : 2019/7/5 19:11
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@UtilityClass
public class SysLogUtils {
    /**
     * 获取日志信息
     *
     * @return
     */
    public SysLogModel getSysLog() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        SysLogModel sysLog = new SysLogModel();
        sysLog.setCreateBy(Objects.requireNonNull(getUserName()));
        sysLog.setType(CommonConstants.STATUS_NORMAL);
        sysLog.setRemoteAddr(ServletUtil.getClientIP(request));
        sysLog.setRequestUri(URLUtil.getPath(request.getRequestURI()));
        sysLog.setMethod(request.getMethod());
        sysLog.setUserAgent(request.getHeader("user-agent"));
        sysLog.setParams(HttpUtil.toParams(request.getParameterMap()));
        sysLog.setServiceId(getClientId());
        return sysLog;
    }

    /**
     * 获取客户端ID
     *
     * @return clientId
     */
    private String getClientId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof OAuth2Authentication) {
            OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
            return oAuth2Authentication.getOAuth2Request().getClientId();
        }

        return null;
    }

    /**
     * 获取用户名称
     *
     * @return
     */
    private String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }

        return authentication.getName();
    }
}
