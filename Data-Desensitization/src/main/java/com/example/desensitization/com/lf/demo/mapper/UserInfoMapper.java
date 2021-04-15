package com.example.desensitization.com.lf.demo.mapper;

import com.example.desensitization.com.lf.demo.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author LF
 * @date 2021/4/14 - 16:45
 */
public interface UserInfoMapper extends JpaRepository<UserInfo, Long> {

    /**
     * 自定义查询示例
     */
    @Query(value="SQL语句",nativeQuery = true)
    void init();
}
