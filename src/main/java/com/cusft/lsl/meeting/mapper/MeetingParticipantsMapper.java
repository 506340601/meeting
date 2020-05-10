package com.cusft.lsl.meeting.mapper;

import com.cusft.lsl.meeting.pojo.Meeting;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @author Long
 * @Date 2020/5/7 18:04
 */
@Repository
public interface MeetingParticipantsMapper {

    // 与会人员的插入：
    @Insert("insert into meetingparticipants (meeting_id,emp_id) values(#{meeting_id},#{emp_id})")
    public boolean insertEmployees(int meeting_id, int emp_id);

}
