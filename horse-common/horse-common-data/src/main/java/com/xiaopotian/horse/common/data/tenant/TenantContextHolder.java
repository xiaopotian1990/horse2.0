package com.xiaopotian.horse.common.data.tenant;

import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.experimental.UtilityClass;

/**
 * ==========================================
 * 租户工具类
 *
 * @author : 小破天
 * @date : 2019/6/19 21:27
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@UtilityClass
public class TenantContextHolder {
    private final ThreadLocal<Integer> THREAD_LOCAL_TENANT = new TransmittableThreadLocal<>();

    /**
     * TTL设置租户ID
     *
     * @param tenantId 租户ID
     */
    public void setTenantId(Integer tenantId) {
        THREAD_LOCAL_TENANT.set(tenantId);
    }

    /**
     * 获取TTL中的租户ID
     *
     * @return
     */
    public Integer getTenantId() {
        return THREAD_LOCAL_TENANT.get();
    }

    /**
     * 清空TTL中的租户ID
     */
    public void clear() {
        THREAD_LOCAL_TENANT.remove();
    }
}
