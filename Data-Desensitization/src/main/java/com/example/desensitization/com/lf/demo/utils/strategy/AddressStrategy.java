package com.example.desensitization.com.lf.demo.utils.strategy;

import com.example.desensitization.com.lf.demo.utils.desensitizationbase.SensitiveStrategy;
import com.example.desensitization.com.lf.demo.utils.SensitiveType;
import org.springframework.stereotype.Component;

/**
 * @author LF
 * @date 2021/4/15 - 14:13
 */
@Component
public class AddressStrategy implements SensitiveStrategy {
    @Override
    public SensitiveType getSensitiveType() {
        return SensitiveType.ADDRESS;
    }

    @Override
    public String maskingData(String str) {
        return SensitiveInfoUtils.address(str, 4);
    }
}
