package com.hyqin.mapper;

import com.hyqin.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

// @Mapper 或者用MapperScan 将接口装配到容器中
@Mapper
public interface EmployeeMapper {
    Employee getEmpById(Integer id);

    void insertEmp(Employee employee);
}
