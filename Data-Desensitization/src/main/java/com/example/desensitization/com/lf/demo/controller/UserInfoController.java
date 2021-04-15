package com.example.desensitization.com.lf.demo.controller;

import com.example.desensitization.com.lf.demo.entity.UserInfo;
import com.example.desensitization.com.lf.demo.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author LF
 * @date 2021/4/14 - 16:47
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoMapper mapper;

    @PostConstruct
    private void init(){
        //mapper.init();
    }

    @PostMapping("/add")
    public UserInfo save(){
        UserInfo user = UserInfo.builder()
                .age(20)
                .idCard("123456789512323")
                .mobile("15899999999")
                .nativePlace("陕西西安雁塔区")
                .sex("0")
                .useName("李白")
                .useNo("100001")
                .build();
        UserInfo info = mapper.save(user);
        return info;
    }

    @GetMapping("/userInfoList")
    public List<UserInfo> getUserInfoList(){
        List<UserInfo> userInfoList = mapper.findAll();
        return userInfoList;
    }

}
