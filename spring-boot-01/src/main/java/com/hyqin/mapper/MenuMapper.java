package com.hyqin.mapper;

import com.hyqin.entity.sys.Entity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {

    /**
     * 查询出来所有的菜单
     * @return
     */
    @Select("select * from menu")
    List<Entity> findTree();

}
