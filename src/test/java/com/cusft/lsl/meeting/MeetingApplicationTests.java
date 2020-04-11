package com.cusft.lsl.meeting;

import com.cusft.lsl.meeting.pojo.Department;
import com.cusft.lsl.meeting.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MeetingApplicationTests {

    @Test
    void contextLoads() {
    }

//    @Test
//    public void testDept(){
//
//        DepartmentService departmentService =new DepartmentService();
//
//        List<Department> list =departmentService.getDept();
//        for (Department d:list) {
//            System.out.println(d);
//        }
//    }
}
