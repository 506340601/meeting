package com.cusft.lsl.meeting.service;

import com.cusft.lsl.meeting.mapper.MeetingMapper;
import com.cusft.lsl.meeting.mapper.MeetingParticipantsMapper;
import com.cusft.lsl.meeting.pojo.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  会议的服务：增删查改
 * @author Long
 * @Date 2020/5/3 18:59
 */
@Service
public class MeetingService {
    // 这里引入MeetingMapper
    @Autowired
    MeetingMapper meetingMapper;

    // 引入MeetingParticipantsMapper
    @Autowired
    MeetingParticipantsMapper meetingParticipantsMapper;

    //会议新增
    public boolean addMeeting(Meeting meeting, List<Integer> employeeIdList) {

        // 新增会议：
        int meeting_id=meeting.getMeeting_id();

        meetingMapper.insertMeeting(meeting);
        //插入与会人员：
        for (Integer emp_id:employeeIdList) {
            meetingParticipantsMapper.insertEmployees(meeting_id,emp_id);
        }

        return false;
    }

    //会议取消
    public boolean updateMeeting(int meeting_id, int status) {

        return meetingMapper.updateMeetingInfo(meeting_id,status);
    }

    // 查询我的会议：
    public List<Meeting> selectMeetings(int emp_id) {
        return meetingMapper.selectMyMeetings(emp_id);
    }


    // 查询已经取消的会议，后面应该加个字段
    public List<Meeting> selectMeetingsByCancel() {
        return meetingMapper.selectCancelMeetings();
    }
}
