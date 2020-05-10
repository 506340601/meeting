package com.cusft.lsl.meeting.controller;

import com.cusft.lsl.meeting.pojo.Employee;
import com.cusft.lsl.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    //密码加密的引入
    @Autowired
    private PasswordEncoder passwordEncoder;


    private Employee emp;


    @PostMapping("/search")
//    public List<Employee> searchEmployees(@RequestParam("username") String username,@RequestParam("emp_name") String emp_name,@RequestParam("status") int status){
    public List<Employee> searchEmployees(@RequestBody Employee emp){

            System.out.println("进入查询方法控制器"+emp.toString());
            String username =emp.getUsername();
            String  emp_name =emp.getEmp_name();
            int status =emp.getStatus();
            System.out.println("从前端传回的条件信息"+emp.getUsername()+emp.getEmp_name()+emp.getStatus());
        return employeeService.searchEmployeesDyn(username,emp_name,status);
    }

    //查询当前用户 可以！
    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user){
        return user;
    }

    //审批操作  成功！
    @PutMapping("/approved/{emp_id:\\d+}")
    public boolean updateStatusInfoSuccessful(@PathVariable int emp_id){

        int status =1;
        return  employeeService.updateStatusInfo(emp_id,status);
    }
    //审批不通过 成功！
    @PutMapping("/noapproval/{emp_id:\\d+}")
    public boolean updateStatusInfo(@PathVariable int emp_id){
        int status =2;
        return  employeeService.updateStatusInfo(emp_id,status);
    }

    //新增员工  成功！
    @PostMapping("/add")
    public int  addEmployee(@RequestBody Employee emp){
        System.out.println("校验从前端传来的数据");
        System.out.println(emp.toString());
        //数据库密码加密
        String password =emp.getEmp_pwd();
        System.out.println("明文密码："+password);

       String  newEmp_pwd=passwordEncoder.encode(password);
        System.out.println("加密后的密码："+newEmp_pwd);
        emp.setEmp_pwd(newEmp_pwd);

        System.out.println("新增员工："+emp.toString());
        return employeeService.addEmployee(emp);
    }

    //查询员工:某个
    @GetMapping("/id")
    public Employee getEmployee(){
        return null;
    }

    //查询按用户名
    @GetMapping("/search/emp_name}")
    public Employee getEmployeeByName(@PathVariable String emp_name){
        return null;
    }

    //员工姓名
    @GetMapping("/search/username")
    public List<Employee> getEmployeeByUsername(@PathVariable String username){
        return employeeService.searchEmployeeByUsername(username);
    }

    //已审批/未审批
    @GetMapping("/serach/{status:\\d+}")
    public List<Employee> getEmployeesByStatus(@PathVariable int status){
        return employeeService.serchEmployeeByStatus(status);
    }

    //查询未审批的用户：
    @GetMapping("/approval")
    public List<Employee> getAllNeedapprovalEmployee(){
        return employeeService.getAllNeedApproval();
    }


    //查询部门员工
    @GetMapping("/{dept_id:\\d+}")//"/{dept_id:\\\\d+}"
    public List<Employee> getEmployees(@PathVariable String dept_id){
        return null;
    }

    //删除员工
    @DeleteMapping("/delete")
    public String deleteEmployee(){
        return "delete employee successful";
    }

    //更新员工
    @PutMapping("/update")
    public String updateEmployee(){
        return "update employee successful";
    }
}
