/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DepartmentMapper
 * Author:   hyqin
 * Date:     2019-09-14 23:08
 * Description: department的mapper映射文件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.mapper;

import com.hyqin.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈department的mapper映射文件〉
 *
 * @author hyqin
 * @create 2019-09-14
 * @since 1.0.0
 */
//  @Mapper  定义，这是一个操作数据库的方法
@Mapper
public interface DepartmentMapper {

    /**
     * 定义一个方法，用mybatis注解的方式，直接用注解写sql语句
     * @param id
     * @return
     */
    @Select("select * from department where id = #{id}")
    Department findDeptById(Integer id);

    @Delete("delete department where id = #{id}")
    int deleteDeptById(Integer id);

    /**
     *  @Options(useGeneratedKeys = true)  设置是否自增主键
     * @param dept
     * @return
     */
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    @Insert("insert into department (departmentName) values(#{departmentName})")
    int insertDept(Department dept);

    @Update("update department set departmentName = #{departmentName} where id = #{id}" )
    int updateDept(Department dept);
}
