package com.cusft.lsl.meeting.pojo;

import lombok.Data;

/**
 * 员工表：
 * @author Long
 * @Date 2020/4/10 13:07
 */
@Data
public class Employee {
    private int emp_id;//员工编号
    private String emp_name;//员工账户名
    private String emp_pwd;//员工密码
    private String phone;//手机号码
    private  String email;//员工邮箱
    private int dept_id;//部门编号
    private String address;//住址
    private String role="1";//考虑是使用数字，1：管理员，2普通用户
    private String sex;//性别：1:男 2:女
    private  String username;//真实姓名
    private  int status =0  ;//状态，如果是用户自己可以申请注册的时候就使用 注册为0，通过审批为1，未通过为2

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //构造方法

    public Employee() {
    }

    //构造方法1 用户验证？

    public Employee(String emp_name, String emp_pwd, String role) {
        this.emp_name = emp_name;
        this.emp_pwd = emp_pwd;
        this.role = role;
    }


    //构造方法2


    //构造方法3 全参

    public Employee(int emp_id, String emp_name, String emp_pwd, String phone, String email, int dept_id, String address, String role, String sex, String username, int status) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_pwd = emp_pwd;
        this.phone = phone;
        this.email = email;
        this.dept_id = dept_id;
        this.address = address;
        this.role = role;
        this.sex = sex;
        this.username = username;
        this.status = status;
    }
}
