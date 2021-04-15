package com.example.desensitization.com.lf.demo.utils.strategy;

import org.apache.commons.lang3.StringUtils;

/**
 * 数据脱敏实现
 * @author LF
 * @date 2021/4/15 - 10:35
 */
public class SensitiveInfoUtils {

    public static String mobilePhone(final String num){
        if(StringUtils.isBlank(num)){
            return StringUtils.EMPTY;
        }
        return StringUtils.left(num, 2)
                .concat(
                        StringUtils.removeStart(
                            StringUtils.leftPad(StringUtils.right(num, 2), StringUtils.length(num), "*"),
                        "***")
                );
    }

    public static String idCardNum(final String num){
        return "";
    }

    public static String fixedPhone(final String num){
        return "";
    }

    public static String address(final String num, int i){
        if(StringUtils.isBlank(num)){
            return StringUtils.EMPTY;
        }else {
            if(StringUtils.length(num) <= i){
                return num;
            }else {
                return StringUtils.left(num, i)
                        .concat(
                                StringUtils.rightPad(StringUtils.right(num, 0),StringUtils.length(num)-i,"*")
                        );
            }
        }
    }

    public static String email(final String num){
        return "";
    }

    public static String bankCard(final String num){
        return "";
    }

    public static String chineseName(final String num){
        return "";
    }

    public static void main(String[] args) {
        String str = "15691666954";
        String concats = StringUtils.left(str, 2)
                .concat(
                        StringUtils.removeStart(
                                StringUtils.leftPad(StringUtils.right(str, 2), StringUtils.length(str), "*"),
                                "****")
                );
        String concats1 = StringUtils.left(str, 2)
                .concat(
                   StringUtils.removeStart(
                        StringUtils.leftPad(StringUtils.right(str, 2), StringUtils.length(str), "*"),
                   "**")
                );
        System.out.println(concats + "-------size----->" + StringUtils.length(concats));
        System.out.println(concats1 + "-------size----->" + StringUtils.length(concats1));
        String address = address(str, 4);
        System.out.println(address);
    }
}
