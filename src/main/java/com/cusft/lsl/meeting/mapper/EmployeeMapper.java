package com.cusft.lsl.meeting.mapper;

import com.cusft.lsl.meeting.pojo.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Long
 * @Date 2020/4/12 13:46
 */
@Repository
public interface EmployeeMapper {

    //增加新员工
    @Insert("insert into employee() values()")
    public String addEmployee();

    //查询员工：按id
    @Select("select * from employee where emp_id=#{emp_id}")
    public Employee getEmployee(int emp_id);

    //查询员工，按部门号
    @Select("select * from employee where dept_id=#{dept_id}")
    public List<Employee> getEmployees();

    //查员工，按会议号？
    @Select("select emp_name from employee e,meetingparticipants  m where m.emp_id =e.emp_id and m.meeting_id=#{meeting_id}")
    public List<Employee> getEmployeesByMeeting(int meeting_id);

    //删除员工,按id
    @Delete("delete from employee where emp_id=#{emp_id}")
    public String deleteEmployee(int emp_id);

    //修改更新员工数据
    @Update("update employee set ")
    public String updateEmployee(Employee empl);

}
