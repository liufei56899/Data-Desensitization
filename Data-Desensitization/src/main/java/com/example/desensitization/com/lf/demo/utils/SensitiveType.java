package com.example.desensitization.com.lf.demo.utils;

/**
 * 数据脱敏的字段枚举
 * @author LF
 * @date 2021/4/15 - 9:54
 */
public enum SensitiveType {
    /**
     * 中文名
     */
    CHINESE_NAME,
    /**
     * 身份证号
     */
    ID_CARD,
    /**
     * 座机号
     */
    FIXED_PHONE,
    /**
     * 手机号
     */
    MOBILE_PHONE,
    /**
     * 地址
     */
    ADDRESS,
    /**
     * 邮箱
     */
    EMAIL,
    /**
     * 银行卡
     */
    BANK_CARD;


}
