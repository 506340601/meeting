package com.cusft.lsl.meeting.service;

import com.cusft.lsl.meeting.mapper.DepartmentMapper;
import com.cusft.lsl.meeting.pojo.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  Service层，方法调用，注入mapper，调用数据库操作；
 *
 * @author Long
 * @Date 2020/4/11 14:32
 */
@Service
public class DepartmentService {

    //注入Mapper
    @Autowired
    DepartmentMapper departmentMapper;


    //查询所有部门
   public List<Department> getDept(){
       return departmentMapper.getDepartmentAll();
   }
//   //更新某个部门
//    public boolean updateDept(){
//       return departmentMapper.
//    }
    //删除某个部门
    public boolean deleteDept(int dept_id){
       return departmentMapper.deleteDept(dept_id);
    }

    //新增某个部门
    public String addDept(Department dept){
       return  departmentMapper.addDept(dept);
    }
}
