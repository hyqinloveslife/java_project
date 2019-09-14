/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Department
 * Author:   hyqin
 * Date:     2019-09-01 22:58
 * Description: 部门类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.bean;

/**
 * 〈一句话功能简述〉<br> 
 * 〈部门类〉
 *
 * @author hyqin
 * @create 2019-09-01
 * @since 1.0.0
 */
public class Department {
    private Integer id;
    private String departmentName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
