package com.xiaopotian.horse.common.log.event;

import com.xiaopotian.horse.common.log.data.SysLogModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * ==========================================
 * 异步监听日志事件
 *
 * @author : 小破天
 * @date : 2019/7/5 20:04
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Slf4j
@AllArgsConstructor
public class SysLogListener {

    /**
     * 日志监听事件
     *
     * @param event
     */
    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        SysLogModel sysLog = event.getSysLog();

        // TODO: 2019/7/5  保存日志
        log.info("log日志模块：{}",sysLog.toString());
    }
}
