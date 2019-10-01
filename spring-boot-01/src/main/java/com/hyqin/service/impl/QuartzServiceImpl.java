/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: QuartzServiceImpl
 * Author:   hyqin
 * Date:     2019-10-01 22:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.service.impl;

import com.hyqin.service.QuartzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hyqin
 * @create 2019-10-01
 * @since 1.0.0
 */
@Component
public class QuartzServiceImpl implements QuartzService {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public int addQuarzts(){
        String [] rdArray = new String[]{"zhangsan","lisi","wangwu","zhaoliu","sunqi","wuba"};
        String name = rdArray[new Random().nextInt(rdArray.length)];
//        String name = "kobe bryant";
        String idCard = new Date().toString();
        String sql =  "insert into ac01_insur(aac002,aac003,aae013) values(?,?,?)";
        int res = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1,name);
                ps.setString(2,idCard);
                ps.setString(3, UUID.randomUUID().toString());
                return ps;
            }
        });
        return res;
    }

}
