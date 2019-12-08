/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BookController
 * Author:   hyqin
 * Date:     2019-10-05 21:44
 * Description: 书本的管理类，负责新增，删除，修改，查询该实体类的信息
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.controller;

import com.hyqin.entity.Books;
import com.hyqin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈书本的管理类，负责新增，删除，修改，查询该实体类的信息〉
 * 同时，定义restful 风格的api
 *          url              method
 * 增加     /booklist         put
 * 删除     /booklist/123     delete
 * 修改     /booklist/123     post
 * 获取     /booklist/123     get
 * 查询     /booklist         get
 *
 * @author hyqin
 * @create 2019-10-05
 * @since 1.0.0
 */
@CrossOrigin
@RequestMapping("/books")
@RestController
public class BookController {


    @Autowired
    private BookService bookService;

    @CrossOrigin
    @GetMapping(value = "/booklist")
    public List<Books> getAllBooks(){
        List<Books> booksList = bookService.queryAllBooks();
        return booksList;
    }

    @CrossOrigin
    @GetMapping("/booklist/{id}")
//    @RequestMapping(value = "/booklist/{id}",method = RequestMethod.GET)
    public Books findBookById(@PathVariable("id") Integer id){
        Books book = bookService.findBookById(id);
        return book;
    }

    @CrossOrigin
    @DeleteMapping("/booklist/{id}")
    public int removeBook(@PathVariable("id") Integer id){
        int res = bookService.removeBookById(id);
        return res;
    }

    /**
     * 在最开始测试restful api的时候，总是接收不到前台传的参数，最终在csdn的社区里看到有人加了  @RequestBody  然后就可以获取到参数了。
     * @param books
     * @param request
     * @param response
     * @return
     */
    @CrossOrigin
    @PostMapping("/booklist")
//    @RequestMapping(value = "/booklist",method = RequestMethod.POST)
    public int addBooks(@RequestBody Books books, HttpServletRequest request, HttpServletResponse response){
        return  bookService.addBooks(books);
    }

}
