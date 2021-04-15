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
     * 初始化数据库表
     */
    @Query(value="CREATE TABLE `user_info` (\n" +
            "  `use_id` bigint(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `use_no` varchar(20) DEFAULT NULL,\n" +
            "  `use_name` varchar(20) DEFAULT NULL,\n" +
            "  `mobile` varchar(11) DEFAULT NULL,\n" +
            "  `sex` char(1) DEFAULT NULL,\n" +
            "  `age` int(3) DEFAULT NULL,\n" +
            "  `native_place` varchar(255) DEFAULT NULL,\n" +
            "  `id_card` bigint(20) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`use_id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;",nativeQuery = true)
    void init();
}
