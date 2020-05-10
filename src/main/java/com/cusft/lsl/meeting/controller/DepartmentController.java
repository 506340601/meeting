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
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    //查询部门
    @GetMapping("/all")
    public List<Department> getDeptAll(){
        List<Department> list =departmentService.getDept();

        if(list.size()==0){
            System.out.println("list为空，数据查询有问题");
        }else{
            for (Department d: list) {
                System.out.println(d);
            }
        }
//        return "测试MyBatis能否正常工作,请看后台输出数据与否";
        return departmentService.getDept();
    }


    //新增部门
    @PostMapping("/add")
    public int addDept(@RequestBody Department dept){
       return departmentService.addDept(dept);
    }
    //删除部门
    @DeleteMapping("{dept_id:\\d+}")
    public boolean delete(@PathVariable int dept_id) {
        System.out.println("进入了部门删除任务操作");
       return departmentService.deleteDept(dept_id);
    }

}
