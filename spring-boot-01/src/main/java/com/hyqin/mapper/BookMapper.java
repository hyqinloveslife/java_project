package com.hyqin.mapper;

import com.hyqin.entity.Books;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    /**
     * 查询系统中所有的书本信息
     * @return 返回一个书本的list
     */
    @Select("select * from tianshop.books ")
    List<Books> queryAllBooks();

    /**
     * 根据书本的系统内id查询出书本的详细信息
     * @param id
     * @return
     */
    @Select("select * from tianshop.books where id = #{id}")
    Books getBookById(Integer id);

    /**
     * 根据书本的系统内id来修改书本的基本信息
     * @param book
     * @return
     */
    @Update("update books set name=#{name},price=#{price},referred =#{referred},author=#{author},desc=#{desc} where id=#{id} ")
    int updateBookMsg(Books book);

    /**
     * 根据系统内的书本id来删除书本信息
     * @param id
     * @return
     */
    @Delete("delete books where id=#{id}")
    int removeBook(Integer id);

    /**
     * 插入一本书
     * @param book
     * @return
     */
    @Insert("insert into books (name,referred,author,price,desc,isbn) values(#{name},#{referred},#{author},#{price},#{desc},#{isbn})")
    int addBooks(Books book);
}
