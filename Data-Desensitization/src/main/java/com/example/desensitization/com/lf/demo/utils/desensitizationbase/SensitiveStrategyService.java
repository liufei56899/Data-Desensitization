package com.example.desensitization.com.lf.demo.utils.desensitizationbase;

import com.example.desensitization.com.lf.demo.utils.SensitiveType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LF
 * @date 2021/4/15 - 13:39
 */
@Service
public class SensitiveStrategyService {
    Map<SensitiveType, SensitiveStrategy> map = new HashMap();

    /**
     * 用map存入枚举类型和对应的策略类
     * @param sensitiveStrategyList
     */
    public SensitiveStrategyService(List<SensitiveStrategy> sensitiveStrategyList) {
        sensitiveStrategyList.forEach(sensitiveStrategy -> map.put(sensitiveStrategy.getSensitiveType(), sensitiveStrategy));
    }

    /**
     * 调用方法
     * @param typeEnum
     * @param str
     * @return
     */
    public String generatorSensitive(SensitiveType typeEnum, String str) {
        SensitiveStrategy sensitiveStrategy = map.get(typeEnum);
        if (sensitiveStrategy != null) {
            return sensitiveStrategy.maskingData(str);
        }
        return StringUtils.EMPTY;
    }

}
