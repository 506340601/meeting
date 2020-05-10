package com.cusft.lsl.meeting.service;

import com.cusft.lsl.meeting.mapper.MeetingParticipantsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  与会者服务调用
 * @author Long
 * @Date 2020/5/7 18:00
 */
@Service
public class MeetingParticipantsService {

    @Autowired
    MeetingParticipantsMapper meetingParticipantsMapper;


}
