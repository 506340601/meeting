package com.cusft.lsl.meeting.service;

import com.cusft.lsl.meeting.pojo.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  员工的功能服务
 * @author Long
 * @Date 2020/4/12 13:12
 */
@Service
public class EmployeeService {

    //员工新增
    public String addEmployee(Employee emp){
        return "";
    }

    //员工删除
    public String deleteEmployee(int epm_id){
        return "";
    }
    //员工查询：指定ID查询
    public Employee getEmployee(int emp_id){
        return null;
    }
    //员工查询：通过部门id

    public List<Employee> getEmployees(int dept_id){
        return null;
    }

    //员工信息修改：通过绑定id
    public String updateEmployee(){
        return "";
    }
}
