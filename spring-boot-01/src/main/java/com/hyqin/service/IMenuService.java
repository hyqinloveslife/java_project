package com.hyqin.service;

import com.hyqin.entity.sys.Entity;
import com.hyqin.entity.sys.Sys_menu;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * 菜单
 */
@Service
public interface IMenuService {
    List<Sys_menu> getChilds(String id, List<Sys_menu> allMenus, List<Entity> entities);

    Comparator<Sys_menu> order();
}
