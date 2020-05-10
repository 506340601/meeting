package com.cusft.lsl.meeting.controller;

import com.cusft.lsl.meeting.pojo.MeetingRoom;
import com.cusft.lsl.meeting.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Long
 * @Date 2020/4/17 21:18
 */
@RestController//表示返回的是一组数据，而不是Controller返回的是页面
@RequestMapping("/room")
public class MeetingRoomController {

    @Autowired
    MeetingRoomService meetingRoomService;
    /*
        会议室：新增、修改、删除
        1、新增：创建新的会议室addMeetingRoom
        2、修改：修改已有的会议室，通过绑定room_id和要修改的内容
        3、删除：直接删除该会议室（或者学GitHub上面的删除仓库一样，删除时需要再次输入名字）
        4、
     */

    //新增会议室
    @PostMapping("/add")
    public boolean addRoom(@RequestBody MeetingRoom meetingRoom){
        return meetingRoomService.addMeetingRoom(meetingRoom);
    }

    //查询所有的会议室
    @GetMapping("/all")
    public List<MeetingRoom> getMeetingRooms(){
        System.out.println("进入了会议查询的方法");
        return meetingRoomService.getMeetingRooms();
    }

    //删除会议室
    @DeleteMapping("{room_id:\\d+}")
    public boolean deleteMeetingRoom(@PathVariable int room_id){

        return meetingRoomService.deleteMeetingRoom(room_id);
    }

}
