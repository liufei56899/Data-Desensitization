package com.example.desensitization.com.lf.demo.utils.desensitizationbase;

import com.example.desensitization.com.lf.demo.utils.ApplicationContextBeanProvider;
import com.example.desensitization.com.lf.demo.utils.SensitiveType;
import com.example.desensitization.com.lf.demo.utils.strategy.SensitiveInfoUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

import java.io.IOException;
import java.util.Objects;

/**
 * @author LF
 * @date 2021/4/15 - 10:13
 */
public class SensitiveDataSerialize extends JsonSerializer<String> implements ContextualSerializer {

    private SensitiveType type;
    public SensitiveDataSerialize(){}
    public SensitiveDataSerialize(final SensitiveType type){
        this.type = type;
    }

    /**
     * 调用jsonHandler(s, jsonGenerator)数据脱敏的方法，这个方法根据不同的枚举类型实现对应的数据脱敏
     * 或者使用策略模式
     * @param s
     * @param jsonGenerator
     * @param serializerProvider
     * @throws IOException
     */
    @Override
    public void serialize(final String s,
                          final JsonGenerator jsonGenerator,
                          final SerializerProvider serializerProvider) throws IOException {
        //jsonHandler(s, jsonGenerator);

        //使用策略模式，我们需要增加类型时，只需要新增一个策略类，在里面重写好对应的方法，其他地方都不需要修改
        //SpringContextHolder.getBean()获取容器中的sensitiveStrategyService实例
        SensitiveStrategyService sensitiveStrategyService =
                ApplicationContextBeanProvider.getBean(SensitiveStrategyService.class);
        String generatorSensitive = sensitiveStrategyService.generatorSensitive(this.type, s);
        jsonGenerator.writeString(generatorSensitive);
    }

    /**
     * 扫描脱敏注解
     * @param serializerProvider
     * @param beanProperty
     * @return
     * @throws JsonMappingException
     */
    @Override
    public JsonSerializer<?> createContextual(final SerializerProvider serializerProvider,
                                              final BeanProperty beanProperty) throws JsonMappingException {

        if (beanProperty != null){
            //String
            if(Objects.equals(beanProperty.getType().getRawClass(), String.class)){
                SensitiveInfo sensitiveInfo = beanProperty.getAnnotation(SensitiveInfo.class);
                if(sensitiveInfo == null){
                    sensitiveInfo = beanProperty.getContextAnnotation(SensitiveInfo.class);
                }else {
                    //获得注解，把注解的value传入SensitiveDataSerialize
                    return new SensitiveDataSerialize(sensitiveInfo.value());
                }

            }
            return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
        }
        return serializerProvider.findNullValueSerializer(null);
    }

    /**
     * 根据不同的枚举类型调用各自的脱敏方法
     * @param s 枚举字段
     * @param jsonGenerator
     * @throws IOException
     */
    private void jsonHandler(String s, JsonGenerator jsonGenerator) throws IOException {
        switch (this.type){
            case CHINESE_NAME: {
                jsonGenerator.writeString(SensitiveInfoUtils.chineseName(s));
                break;
            }
            case ID_CARD: {
                jsonGenerator.writeString(SensitiveInfoUtils.idCardNum(s));
                break;
            }
            case FIXED_PHONE: {
                jsonGenerator.writeString(SensitiveInfoUtils.fixedPhone(s));
                break;
            }
            case MOBILE_PHONE: {
                jsonGenerator.writeString(SensitiveInfoUtils.mobilePhone(s));
                break;
            }
            case ADDRESS: {
                jsonGenerator.writeString(SensitiveInfoUtils.address(s, 4));
                break;
            }
            case EMAIL: {
                jsonGenerator.writeString(SensitiveInfoUtils.email(s));
                break;
            }
            case BANK_CARD: {
                jsonGenerator.writeString(SensitiveInfoUtils.bankCard(s));
                break;
            }
            default: {
                break;
            }
        }
    }
}
