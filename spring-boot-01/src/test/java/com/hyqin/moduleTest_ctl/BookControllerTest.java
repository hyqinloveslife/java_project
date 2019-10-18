/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BookControllerTest
 * Author:   hyqin
 * Date:     2019-10-12 23:38
 * Description: controller的单元测试类的api
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.moduleTest_ctl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyqin.entity.Books;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈controller的单元测试类的api〉
 *
 * @author hyqin
 * @create 2019-10-12
 * @since 1.0.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;  //mockMvn实现了对http请求的模拟，能够直接使用网络的形式
    private MockHttpSession session;

    @Autowired
    private ObjectMapper mapper;


    @Before
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化mockmvc
        session = new MockHttpSession();
        //如果拦截器这边有验证用户，那么必须用session来判断用户是否登陆
    }

    /**
     * 获取书本测试用例
     * @throws Exception
     */
    @Test
    public void qryBook() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/books/booklist/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .session(session))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("龚曙光"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("日子疯长"))
                .andDo(MockMvcResultHandlers.print());

    }


    /**
     * 新增书本的测试用例
     * @throws Exception
     */
    @Test
    public void addBook() throws Exception{
        Books books = new Books();
        books.setAuthor("吴承恩");
        books.setDesc("唐僧师徒打怪升级的故事");
        books.setIsbn("192-1232-1882323-12");
        books.setPrice(23.18);
        books.setName("《西游记》");
        books.setPublishDate("人民日报出版社");
        books.setReferred("灵台方寸山，斜月三星洞");

        //perform,执行一个RequestBuilders请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
        mockMvc.perform(
                ////构造一个post请求
                MockMvcRequestBuilders.post("/books/booklist")
                .contentType(MediaType.APPLICATION_JSON_UTF8)

                //使用writeValueAsString()方法来获取对象的JSON字符串表示
                .content(mapper.writeValueAsString(books)))

                //andExpect，添加ResultMathcers验证规则，验证控制器执行完成后结果是否正确，【这是一个断言】
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))

                //假定返回的结果中，"name" 值为 "Mock测试2",如果不是的话，会抛出异常java.lang.AssertionError，并给出期望值和实际值
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("《西游记》"))

                //添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                .andDo(MockMvcResultHandlers.print())

                //返回相应的mvcresult
                .andReturn();

    }



}
