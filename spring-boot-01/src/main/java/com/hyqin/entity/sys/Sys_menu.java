/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Sys_menu
 * Author:   hyqin
 * Date:     2019-12-07 19:08
 * Description: 菜单实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.entity.sys;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈菜单实体类〉
 *
 * @author hyqin
 * @create 2019-12-07
 * @since 1.0.0
 */
public class Sys_menu {
    private Entity entity;

    private List<Sys_menu> childs;

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public List<Sys_menu> getChilds() {
        return childs;
    }

    public void setChilds(List<Sys_menu> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        if (this.childs.size()==0){
            return "Sys_menu{" +
                    "entity=" + entity + '}';
        }else{
            return "Sys_menu{" +
                    "entity=" + entity +
                    ", childs=" + childs +
                    '}';
        }
    }
}
