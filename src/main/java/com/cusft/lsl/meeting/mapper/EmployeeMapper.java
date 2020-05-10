package com.cusft.lsl.meeting.mapper;

import com.cusft.lsl.meeting.pojo.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Long
 * @Date 2020/4/12 13:46
 */
@Repository
public interface EmployeeMapper {

    //增加新员工
    @Insert("insert into employee(emp_name,emp_pwd,phone,email,dept_id,address,role,sex,username,status) values(#{emp_name},#{emp_pwd},#{phone},#{email},#{dept_id},#{address},#{role},#{sex},#{username},#{status})")
    public int addEmployee(Employee emp);

    //查询数据库密码进行登录校验
    @Select("select emp_pwd from employee where emp_name=#{emp_name}")
    public String getEmpPassword (String username);

    //查询员工：按id
    @Select("select * from employee where emp_id=#{emp_id}")
    public Employee getEmployee(int emp_id);

    //查询员工，按部门号
    @Select("select * from employee where dept_id=#{dept_id}")
    public List<Employee> getEmployees();

    //查员工，按会议号？
    @Select("select emp_name from employee e,meetingparticipants  m where m.emp_id =e.emp_id and m.meeting_id=#{meeting_id}")
    public List<Employee> getEmployeesByMeeting(int meeting_id);


    //员工查询，按用户名emp_name
    @Select("select * from employee where emp_name=#{emp_name}")
    public Employee getEmployeeByName(String emp_name);

    //员工查询，按用户姓名
    @Select("select * from employee where username=#{username}")
    public List<Employee> getEmployeeByUsername(String username);

    //员工查询，按审批状态
    @Select("select * from employee where status=#{status}")
    public List<Employee> getEmployeeByStatus(int status);

    //员工审批更新
    @Update("update employee set status=#{status} where emp_id=#{emp_id}")
    public boolean UpdateStatusInfo(int emp_id,int status);


    /*
            以下为代写完成
     */

    //删除员工,按id
    @Delete("delete from employee where emp_id=#{emp_id}")
    public String deleteEmployee(int emp_id);

    //修改更新员工数据
    @Update("update employee set ")
    public String updateEmployee(Employee empl);

    //查找所有待审批的
    @Select("select * from employee where status=0")
    public List<Employee> getAllNeedApproval();

    //动态查询用户
    @SelectProvider(type = Emp_Dyn.class,method = "selectByDyn")
    List<Employee> searchEmployeesByDyn(String username, String emp_name, int status);

    /*
        创建一个内部类，配合注解@SelectProvider:实现动态SQL

     */
    class Emp_Dyn{
        public String selectByDyn(String username, String emp_name, int status){
            String sql="select emp_name,username,phone,email,dept_id,status from employee ";
            Integer test=status;
            if(emp_name!=null){
                sql=sql+"where emp_name=#{emp_name}";
            }else if(username !=null){
                sql=sql+" and username =#{username}";
            }else if(test!=null){
                sql=sql+" and status =#{status}";
            }
            return sql;
        }
    }
}
