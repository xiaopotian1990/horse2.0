package com.xiaopotian.horse.common.log.aspect;

import com.xiaopotian.horse.common.log.annotation.SysLogAnnotation;
import com.xiaopotian.horse.common.log.data.SysLogModel;
import com.xiaopotian.horse.common.log.event.SysLogEvent;
import com.xiaopotian.horse.common.log.util.SysLogUtils;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEventPublisher;

/**
 * ==========================================
 * 操作日志使用spring event异步入库
 *
 * @author : 小破天
 * @date : 2019/7/5 20:09
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Slf4j
@Aspect
@AllArgsConstructor
public class SysLogAspect {
    private final ApplicationEventPublisher publisher;

    /**
     * aop实现拦截
     *
     * @param point
     * @param sysLog
     * @return
     */
    @SneakyThrows
    @Around("@annotation(sysLog)")
    public Object around(ProceedingJoinPoint point, SysLogAnnotation sysLog) {
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        log.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);

        SysLogModel log = SysLogUtils.getSysLog();
        log.setTitle(sysLog.value());

        //发送异步日志事件
        long startTime = System.currentTimeMillis();
        Object obj = point.proceed();
        long endTime = System.currentTimeMillis();
        log.setTime(endTime - startTime);
        publisher.publishEvent(new SysLogEvent(log));

        return obj;
    }
}
