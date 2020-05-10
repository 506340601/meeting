package com.cusft.lsl.meeting.mapper;

import com.cusft.lsl.meeting.pojo.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Long
 * @Date 2020/4/11 14:44
 */
//@Mapper //是用这个注解的时候会出现Service层出现报错的情况，这是新版IDEA的不兼容问题，使用@Repository就可以解决那个红色报错的问题

@Repository
public interface DepartmentMapper {

    //查询所有部门
    @Select("select * from department")
    public List<Department> getDepartmentAll();

    //修改更新某个部门
//    @Update("")
    //删除某个部门
    @Delete("delete from department where dept_id=#{dept_id}")
    public boolean deleteDept(int dept_id);

    //插入新增某个部门
    @Insert("insert into department(dept_name) values(#{dept_name})")
    public int addDept(Department dept);



}
