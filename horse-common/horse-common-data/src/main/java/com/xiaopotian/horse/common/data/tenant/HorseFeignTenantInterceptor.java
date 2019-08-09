package com.xiaopotian.horse.common.data.tenant;

import com.xiaopotian.horse.common.core.constant.CommonConstants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ==========================================
 * open feign设置请求头
 *
 * @author : 小破天
 * @date : 2019/6/19 21:26
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Slf4j
public class HorseFeignTenantInterceptor implements RequestInterceptor {
    @Autowired
    HorseTenantConfigProperties horseTenantConfigProperties;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (!horseTenantConfigProperties.getIsOpen()) {
            return;
        }
        if (TenantContextHolder.getTenantId() == null) {
            log.error("TTL中的租户ID为空，feign拦截器 >> 增强失败");
            return;
        }

        requestTemplate.header(CommonConstants.TENANT_ID, TenantContextHolder.getTenantId().toString());
    }
}
