/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: MenuController
 * Author:   hyqin
 * Date:     2019-12-08 13:32
 * Description: 菜单控制类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hyqin.entity.sys.Entity;
import com.hyqin.entity.sys.Sys_menu;
import com.hyqin.mapper.MenuMapper;
import com.hyqin.service.IMenuService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈菜单控制类〉
 *
 * @author hyqin
 * @create 2019-12-08
 * @since 1.0.0
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@CrossOrigin
@RequestMapping("/menu")
@RestController
public class MenuController {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private IMenuService iMenuService;

    //生成树
    @CrossOrigin
    @GetMapping(value ="findTree.do")
    public Map<String,Object> findTree(){
        Map<String,Object> data = new HashMap<>();
        try {
            //查询所有菜单
            List<Entity> entities = menuMapper.findTree();

//            List<Sys_menu> allMenu = menuMapper.findTree();
            //根节点
            List<Sys_menu> rootMenu = new ArrayList<>();
            for (Entity nav:entities){
                if (nav.getParentId().equals("1")){ //父节点是0，为根节点
                    Sys_menu root = new Sys_menu();
                    root.setEntity(nav);
                    rootMenu.add(root);
                }
            }

            /*菜单排序*/
            //Collections.sort(rootMenu,iMenuService.order());

            //为根菜单设置子节点,getChild是递归调用的
            for (Sys_menu nav : rootMenu){
                /* 获取根节点下的所有子节点 使用getChild方法*/
                List<Sys_menu> childList = iMenuService.getChilds(nav.getEntity().getId(),rootMenu,entities);
//                Sys_menu menu = new Sys_menu();
//                menu.setChilds(childList);//给根节点设置子节点
                nav.setChilds(childList);
            }

            //专成json对象的时候，去除空值
            //创建JsonConfig对象
            JsonConfig jsonConfig = new JsonConfig();

            PropertyFilter filter = new PropertyFilter() {
                @Override
                public boolean apply(Object object, String fieldName, Object fieldValue) {
                    if (fieldValue instanceof List){
                        List<Object> list = (List<Object>) fieldValue;
                        if (list.size()==0){
                            return true;//处理list类的时候，当lilst的大小等于0的时候，返回true过滤该属性
                        }
                    }
                    return null==fieldValue||"".equals(fieldValue);
                }
            };

            jsonConfig.setJsonPropertyFilter(filter);
            JSONArray jsonArray = JSONArray.fromObject(rootMenu,jsonConfig);

            data.put("success",true);
            data.put("list",jsonArray);
        }catch (Exception e){
            data.put("success",false);
            data.put("list",new ArrayList<>());
            return data;
        }



        return data;
    }


}
