package com.example.desensitization.com.lf.demo.utils.strategy;

import com.example.desensitization.com.lf.demo.utils.desensitizationbase.SensitiveStrategy;
import com.example.desensitization.com.lf.demo.utils.SensitiveType;
import org.springframework.stereotype.Component;

/**
 * @author LF
 * @date 2021/4/15 - 13:37
 */
@Component
public class MobilePhoneStrategy implements SensitiveStrategy {

    /**
     * 返回手机号类型枚举
     * @return
     */
    @Override
    public SensitiveType getSensitiveType() {
        return SensitiveType.MOBILE_PHONE;
    }

    /**
     * 调用对应的手机号脱敏方法
     * @param str
     * @return
     */
    @Override
    public String maskingData(String str) {
        return SensitiveInfoUtils.mobilePhone(str);
    }
}
