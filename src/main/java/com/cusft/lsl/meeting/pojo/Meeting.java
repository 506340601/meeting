package com.cusft.lsl.meeting.pojo;

import lombok.Data;

/**
 *  会议实例：
 * @author Long
 * @Date 2020/4/10 13:14
 */
@Data
public class Meeting {
    private int meetingID;//会议编号'meeting_id', 'int(11)', 'NO', 'PRI', NULL, 'auto_increment'
    private String meetingNmae;//会议名
    private int roomID;//会议室编号
    private int reservationistId;//预订者编号
    private int number;//会议人数
    private String startTime;//会议开启时间
    private String endTime;//会议结束时间
    private String reservationTime;//会议预定时间
    private String canceledTime;//会议取消时间
    private String description;//会议描述、文献
    private String status;//会议状态：0：正常1：取消
}
