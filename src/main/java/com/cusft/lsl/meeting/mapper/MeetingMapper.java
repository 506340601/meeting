package com.cusft.lsl.meeting.mapper;

import com.cusft.lsl.meeting.pojo.Meeting;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会议信息相关操作：增、删、查、改
 *
 * @author Long
 * @Date 2020/5/7 11:29
 */
@Repository
public interface MeetingMapper {

    //增加会议
    @Insert("insert into meeting (meeting_name,number,starttime,endtime,reservationtime,room_id,description,status) values(#{meeting_name},#{number},#{starttime},#{endtime},#{reservationtime},#{room_id},#{description},#{status})")
    public void insertMeeting(Meeting meeting);


    // 删除会议：将会议状态status：2   改变就行
    @Update("update meeting set status=#{status} where meeting_id =#{meeting_id}")
    public boolean updateMeetingInfo(int meeting_id,int status);

    // 查询 我的预订
    @Select("select * from meeting where emp_id=#{emp_id}")
    public List<Meeting> selectMyBook(int emp_id);

    //查询已经取消的会议：
    @Select("select * from meeting where status=2")
    public List<Meeting> selectCancelMeetings();

    // 修改：使用模态对话框

    //查询我的会议
    @Select("select * from meeting where emp_id=#{emp_id}")
    public List<Meeting> selectMyMeetings(int emp_id);

}
