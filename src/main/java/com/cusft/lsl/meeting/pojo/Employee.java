package com.cusft.lsl.meeting.pojo;

import lombok.Data;

/**
 * 员工表：
 * @author Long
 * @Date 2020/4/10 13:07
 */
@Data
public class Employee {
    private int empID;//员工编号
    private String empName;//员工账户名
    private String empPwd;//员工密码
    private int phone;//手机号码
    private  String email;//员工邮箱
    private int deptId;//部门编号
    private String addres;//住址
    private String role="2";//考虑是使用数字，1：管理员，2普通用户
    private String sex;//性别：男女
    private  String userName;//真实姓名
    private  String status;//状态，如果是用户自己可以申请注册的时候就使用

    //构造方法
    public Employee() {
    }

    //构造方法1 用户验证？

    public Employee(String empName, String empPwd, String role) {
        this.empName = empName;
        this.empPwd = empPwd;
        this.role = role;
    }

    //构造方法2


    //构造方法3 全参
    public Employee(int empID, String empName, String empPwd, int phone, String email, int deptId, String addres, String role, String sex, String userName, String status) {
        this.empID = empID;
        this.empName = empName;
        this.empPwd = empPwd;
        this.phone = phone;
        this.email = email;
        this.deptId = deptId;
        this.addres = addres;
        this.role = role;
        this.sex = sex;
        this.userName = userName;
        this.status = status;
    }
}
