package com.hyqin.service;

import com.hyqin.entity.Books;
import com.hyqin.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Books> queryAllBooks() {
        System.out.println("===========查询所有书本的信息");
        return bookMapper.queryAllBooks();
    }

    public Books findBookById(Integer id) {
        System.out.println("===========根据id来查询书本的信息");
        return bookMapper.getBookById(id);
    }

    public int removeBookById(Integer id) {
        return bookMapper.removeBook(id);
    }

    public int addBooks(Books books) {
        return bookMapper.addBooks(books);
    }
}
