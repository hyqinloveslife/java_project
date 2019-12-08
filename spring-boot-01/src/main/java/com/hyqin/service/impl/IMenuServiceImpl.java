/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: IMenuServiceImpl
 * Author:   hyqin
 * Date:     2019-12-08 13:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.service.impl;

import com.hyqin.entity.sys.Entity;
import com.hyqin.entity.sys.Sys_menu;
import com.hyqin.service.IMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author hyqin
 * @create 2019-12-08
 * @since 1.0.0
 */
@Service
public class IMenuServiceImpl implements IMenuService {

    @Override
    public List<Sys_menu> getChilds(String id, List<Sys_menu> allMenus, List<Entity> entities) {
        //子菜单
        List<Sys_menu> childList = new ArrayList<>();

        for (Entity entity : entities){
            //遍历所有节点，讲所有菜单的父id与传过来的根节点id进行比较
            //相等说明：为该根节点的子节点
            if (entity.getParentId().equals(id)){
                Sys_menu menu = new Sys_menu();
                menu.setEntity(entity);
                childList.add(menu);
            }
        }

//        for (Sys_menu nav : allMenus){
//            if (nav.getEntity().getParentId().equals(id)){
//                childList.add(nav);
//            }
//        }
        //递归
        for (Sys_menu nav:childList){
            nav.setChilds(getChilds(nav.getEntity().getId(),allMenus,entities));
        }

        //Collections.sort(childList,order()); //对菜单进行排序
        if (childList.size()==0){
            return new ArrayList<>();
        }

        return childList;
    }


    /**
     * 排序
     */
    @Override
    public Comparator<Sys_menu> order(){
        Comparator<Sys_menu> comparator = new Comparator<Sys_menu>() {
            @Override
            public int compare(Sys_menu o1, Sys_menu o2) {
                return o1.getEntity().getOrder()-o2.getEntity().getOrder();
            }
        };
        return comparator;
    }

}
