package com.cusft.lsl.meeting.service;

import com.cusft.lsl.meeting.mapper.MeetingRoomMapper;
import com.cusft.lsl.meeting.pojo.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Long
 * @Date 2020/4/27 10:46
 */
@Service
public class MeetingRoomService {

    @Autowired
    MeetingRoomMapper meetingRoomMapper;

    //新增会议室
    public boolean addMeetingRoom(MeetingRoom meetingRoom){

        return meetingRoomMapper.addMeetingRoom(meetingRoom);
    }

    //查询会议室
    public List<MeetingRoom> getMeetingRooms(){

        return meetingRoomMapper.getMeetingRooms();
    }

    //删除会议室
    public boolean deleteMeetingRoom(int room_id){
        return meetingRoomMapper.deleteMeetingRoom(room_id);
    }
}
