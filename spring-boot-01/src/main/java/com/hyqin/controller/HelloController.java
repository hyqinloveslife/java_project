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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * @return
     */
    @RequestMapping({"/","index.do"})
    public String index(){
        return "logo";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){

        return "hello world! start with 8081";
    }
}
