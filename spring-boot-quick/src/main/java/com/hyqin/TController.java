/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TController
 * Author:   hyqin
 * Date:     2019-09-01 18:24
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin;

import com.hyqin.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hyqin
 * @create 2019-09-01
 * @since 1.0.0
 */

@RestController
public class TController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    IService service;


    @ResponseBody
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from employee");
        return list.toString();
    }

    @GetMapping("/getstr.do")
    public String getStr(){
        return service.getStr();

    }

}
