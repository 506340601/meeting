package com.cusft.lsl.meeting.controller;

import com.cusft.lsl.meeting.pojo.Department;
import com.cusft.lsl.meeting.service.DepartmentService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Long
 * @Date 2020/4/11 14:41
 */
@RestController
@RequestMapping("/test")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    //查询部门
    @GetMapping("/dept")
    public String  getDeptAll(){
        List<Department> list =departmentService.getDept();

        if(list.size()==0){
            System.out.println("list为空，数据查询有问题");
        }else{
            for (Department d: list) {
                System.out.println(d);
            }
        }
        return "测试MyBatis能否正常工作,请看后台输出数据与否";
    }


    //新增部门
    @PostMapping("/dept/add")
    public String addDept(@RequestBody Department dept){
       return departmentService.addDept(dept);
    }
    //删除部门
    @Delete("/dept/{t_id:\\\\d+}")
    public boolean delete(@PathVariable int dept_id) {
       return departmentService.deleteDept(dept_id);
    }


    @GetMapping("data")
    public String getData(){
        return "测试MyBatis能否正常工作";
    }
}
