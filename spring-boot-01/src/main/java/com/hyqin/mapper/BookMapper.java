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
     *
     *com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException:
     * You have an error in your SQL syntax; check the manual that corresponds to your MySQL server
     * version for the right syntax to use near 'desc) values('三国演义','东汉末年，魏蜀吴三个国家争霸的故事' at line 1
     * 	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
     * 	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
     * 	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
     * 	at java.lang.reflect.Constructor.newInstance(Constructor.java:422)
     *  最后发现，是因为desc是MySQL里面的关键字，所以关键字冲突了
     * @return
     */
    @Insert("insert into tianshop.books " +
            "(name,referred,author,price,isbn,published,publishDate,description) " +
            "values" +
            "(#{name},#{referred},#{author},#{price},#{isbn},#{published},#{publishDate},#{description})")
    int addBooks(Books book);
}
