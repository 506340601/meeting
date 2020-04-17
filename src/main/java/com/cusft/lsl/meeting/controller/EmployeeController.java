package com.cusft.lsl.meeting.controller;

import com.cusft.lsl.meeting.pojo.Employee;
import com.cusft.lsl.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  员工类的控制器
 * @author Long
 * @Date 2020/4/11 21:33
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //查询员工:某个
    @GetMapping()
    public Employee getEmployee(){
        return null;
    }
    //查询部门员工
    @GetMapping()
    public List<Employee> getEmployees(){
        return null;
    }
    //新增员工
    @PostMapping()
    public String  addEmployee(){
        return "add new Employee ok!!!";
    }
    //删除员工
    @DeleteMapping()
    public String deleteEmployee(){
        return "delete employee successful";
    }

    //更新员工
    @PutMapping()
    public String updateEmployee(){
        return "update employee successful";
    }
}
