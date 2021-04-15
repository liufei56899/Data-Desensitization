package com.example.desensitization.com.lf.demo.utils.desensitizationbase;

import com.example.desensitization.com.lf.demo.utils.SensitiveType;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自定义数据脱敏的注解
 * @author LF
 * @date 2021/4/15 - 10:33
 */
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = SensitiveDataSerialize.class)
public @interface SensitiveInfo {
    SensitiveType value();
}
