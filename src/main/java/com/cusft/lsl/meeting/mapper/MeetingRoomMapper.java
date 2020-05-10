package com.cusft.lsl.meeting.mapper;

import com.cusft.lsl.meeting.pojo.MeetingRoom;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会议室管理：
 * @author Long
 * @Date 2020/4/27 10:47
 */
@Repository
public interface MeetingRoomMapper {
    //新增会议室
    @Insert("insert into meetingroom(`roomnum`,`room_name`,`capacity`,`status`,`desc`) values(#{roomnum},#{room_name},#{capacity},#{status},#{desc})")
    public boolean addMeetingRoom(MeetingRoom meetingRoom);

    //查询会议室
    @Select("select * from meetingroom")
    public List<MeetingRoom> getMeetingRooms();

    //删除会议室
    @Delete("delete from meetingroom where room_id=#{room_id}")
    public boolean deleteMeetingRoom(int room_id);

}
