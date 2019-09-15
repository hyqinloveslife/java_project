/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DeptController
 * Author:   hyqin
 * Date:     2019-09-14 23:20
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyqin.controller;

import com.hyqin.bean.Department;
import com.hyqin.bean.Employee;
import com.hyqin.mapper.DepartmentMapper;
import com.hyqin.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author hyqin
 * @create 2019-09-14
 * @since 1.0.0
 */
@RestController
public class DeptController {

    @Autowired
    DepartmentMapper deptMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id) {
        return deptMapper.findDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department) {

        deptMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeMapper.getEmpById(id);
    }

}
