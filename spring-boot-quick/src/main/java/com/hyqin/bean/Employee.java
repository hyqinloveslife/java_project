/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Employee
 * Author:   hyqin
 * Date:     2019-09-01 22:56
 * Description: 员工类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.bean;

/**
 * 〈一句话功能简述〉<br> 
 * 〈员工类〉
 *
 * @author hyqin
 * @create 2019-09-01
 * @since 1.0.0
 */
public class Employee {
    private Integer id;
    private String lastName;
    private Integer gender;
    private String emai;
    private Integer dId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }
}
