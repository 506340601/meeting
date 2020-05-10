package com.cusft.lsl.meeting.controller;

import com.cusft.lsl.meeting.pojo.Meeting;
import com.cusft.lsl.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Long
 * @Date 2020/4/17 20:38
 */
@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private MeetingService meetingService;
    /*
        会议的增删查改:
            1、新增会议，提交到管理员那里审核，默认值为0，通过为1，取消为2
            2、会议的修改：时间地点等等
            3、会议的查询：通过会议时间、会议内容--模糊搜索？、预约的人来查询？
            4、会议的取消：将会议状态改为2？
     */

    //会议新增  :主要是与会人员的管理麻烦
    //设想，将会议信息meeting   和与会人员列表EmployeeIdList信息传回
    @PostMapping("/add")
    public boolean addMeeting(@RequestBody Meeting meeting,List<Integer> employeeIdList){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println("当前系统时间（会议预订）"+df.format(new Date()));// new Date()为获取当前系统时间
        String sys_time=df.format(new Date());

        meeting.setReservationtime(sys_time);

//        有时候要把String类型的时间转换为Date类型，通过以下的方式，就可以将你刚得到的时间字符串转换为Date类型了。
//
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//
//        java.util.Date time=null;
//        try {
//            time= sdf.parse(sdf.format(new Date()));
//
//        } catch (ParseException e) {
//
//            e.printStackTrace();
//        }
//        reservationtime 会议预定时间

        return meetingService.addMeeting(meeting,employeeIdList);
    }

    //会议取消：绑定会议id,实现会议状态的修改即可：status=0
    @PutMapping("{meeting_id:\\d+}")
    public boolean updateMeeting(@PathVariable int meeting_id){

        int status=2;
        return meetingService.updateMeeting(meeting_id,status);
    }

    @GetMapping("/mybook/{emp_id:\\d+}")
    public List<Meeting> selectMyBook(@PathVariable int emp_id){
        return meetingService.selectMeetings(emp_id);
    }

    /*
        会议查询：
            1.按时间查询接下来的一周， between,当前查询时间以及接下来的七天
            2、已取消的会议：会议状态status为0取消
            3、我的会议：按用户id查询，我的会议：select * from meeting where meeting_id=#{meeting_id}
            4、会议名称查询：
            5、会议时间查询：查询某段时间，举办的会议
     */
    //个人
    @GetMapping("/me")
    public List<Meeting> selectMeetings(@PathVariable int emp_id){

        return meetingService.selectMeetings(emp_id);
    }

    //最新通知的：接下来一周的会议
    @GetMapping("/newInfo")
    public List<Meeting> selectMeetingsNewInfo(){
        //获取系统当前时间：然后传入，在mysql里面进行比较判断
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println("查询一周会议的1当前系统时间"+df.format(new Date()));// new Date()为获取当前系统时间
        return null;
    }
    //查询已取消的
    @GetMapping("/cancel")
    public List<Meeting> selectCancelMeetings(){
        //查询数据库里面会议状态为status：2 的，并且按照order by 会议时间statrtime进行排序
        return meetingService.selectMeetingsByCancel();
    }

    //查询某个主题的会议
    @GetMapping("/topical")
    public List<Meeting> selectMeetingsByTopical(@PathVariable String meeting_name){
        //利用名字进行主题模糊查询：可以少打，不多可以多打字
        return null;
    }

    //查询某个时间（一天的会议）
    @GetMapping("/oneday")
    public List<Meeting> selectMeetingsByOneday(@PathVariable Date date){
        //利用名字进行主题模糊查询：可以少打，不多可以多打字
        return null;
    }

    //会议修改：文献内容，描述那里可以做会议文献修改：

}
