/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: HelloController
 * Author:   hyqin
 * Date:     2019-07-02 22:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.controller;

import com.hyqin.util.ExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author hyqin
 * @create 2019-07-02
 * @since 1.0.0
 */

@Controller
public class HelloController {

    /**
     * 默认进来后的首页
     *
     * @return
     */
    @RequestMapping({"/", "index.do"})
    public String index() {
        return "logo";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {

        return "hello world! start with 8081";
    }

    @RequestMapping("/export")
    public String export(HttpServletResponse response) {
        List<Map<String, String>> dataSource = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("${no}", "1");
        map.put("${aac001}", "12312");
        map.put("${aac002}", "131231242352");
        map.put("${aac003}", "张三");
        map.put("${aac004}", "男");
        dataSource.add(map);

        String [] keyArray = {"${no}","${aac001}","${aac002}","${aac003}","${aac004}"};
        String [] sheetArray = {"叶问","霍元甲","黄飞鸿","方世玉"};
        String modelUrl = "d:\\test.xls";

        try {
            ExcelUtils.ExcelByModel("测试导出",modelUrl,dataSource,response,sheetArray,keyArray,1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "s";
    }


}
