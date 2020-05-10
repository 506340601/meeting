package com.cusft.lsl.meeting.service;

import com.cusft.lsl.meeting.mapper.EmployeeMapper;
import com.cusft.lsl.meeting.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  员工的功能服务
 * @author Long
 * @Date 2020/4/12 13:12
 */
@Service
public class EmployeeService {

    //注入依赖
    @Autowired
    EmployeeMapper employeeMapper;

    //员工注册审批操作

    public boolean updateStatusInfo(int emp_id,int status){
        System.out.println("审批状态通过service层"+status);
        return employeeMapper.UpdateStatusInfo(emp_id,status);
    }
    //员工新增
    public int addEmployee(Employee emp){
        return employeeMapper.addEmployee(emp);
    }

    //员工查询，按用户名emp_name
    public Employee searchEmployeeByname(String emp_name){

        return employeeMapper.getEmployeeByName(emp_name);
    }

    //员工查询，按用户姓名
    public List<Employee> searchEmployeeByUsername(String username){
        return employeeMapper.getEmployeeByUsername(username);
    }

    //员工查询，按审批状态
    public List<Employee> serchEmployeeByStatus(int status){
        return employeeMapper.getEmployeeByStatus(status);
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

    //查询所有待审批的用户
    public List<Employee> getAllNeedApproval() {
        return employeeMapper.getAllNeedApproval();
    }

    //动态查询用户
    public List<Employee> searchEmployeesDyn(String username, String emp_name, int status) {
        return employeeMapper.searchEmployeesByDyn(username,emp_name,status);
    }
}
