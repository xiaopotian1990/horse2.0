package com.xiaopotian.horse.biz.order.server.view;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * ==========================================
 * Created with IntelliJ IDEA.
 * User: 小破天
 * Date: 2019-05-19
 * Time: 11:18
 * 博客园：http://www.cnblogs.com/xiaopotian/
 * ===========================================
 */
@Data
@AllArgsConstructor
public class ConfigVM implements Serializable {
    private String name;
    private Integer age;
}
