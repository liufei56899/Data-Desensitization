package com.example.desensitization.com.lf.demo.utils.desensitizationbase;

import com.example.desensitization.com.lf.demo.utils.SensitiveType;

/**
 * 策略模式接口
 * @author LF
 * @date 2021/4/15 - 13:35
 */
public interface SensitiveStrategy {
    /**
     * 获取对应枚举类型的方法
     * @return
     */
    SensitiveType getSensitiveType();

    /**
     * 实现数据脱敏的方法
     * @param str
     * @return
     */
    String maskingData(String str);
}
