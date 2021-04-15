package com.example.desensitization.com.lf.demo.entity;

import com.example.desensitization.com.lf.demo.utils.desensitizationbase.SensitiveInfo;
import com.example.desensitization.com.lf.demo.utils.SensitiveType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author LF
 * @date 2021/4/14 - 16:11
 */
@Data
@Entity(name = "user_info")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column(length = 11)
    private Long useId;
    @Column(length = 20)
    private String useNo;
    @Column(length = 20)
    private String useName;
    /**
     * 数据脱敏的注解
     */
    @SensitiveInfo(SensitiveType.MOBILE_PHONE)
    @Column(length = 11)
    private String mobile;
    @Column(length = 1)
    private String sex;
    @Column(length = 3)
    private Integer age;
    /**
     * 数据脱敏的注解
     */
    @SensitiveInfo(SensitiveType.ADDRESS)
    @Column(length = 250)
    private String nativePlace;
    @Column(length = 18)
    private String idCard;
}
