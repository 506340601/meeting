package com.cusft.lsl.meeting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 与会人员控制器
 *
 * @author Long
 * @Date 2020/4/17 21:26
 */
@RestController
@RequestMapping("/participants")
public class MeetingParticipantsController {
    /*
        与会人员的信息管理：
            插入：考虑如何选择一个会议meeting_id，插入多组用户emp_id
            查询的时候:
                一：通过某个会议meeting_id来查出所有的与人人员信息；
                二：通过

     */
}
