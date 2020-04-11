package com.cusft.lsl.meeting.pojo;

import lombok.Data;

/**
 *  会议室：
 * @author Long
 * @Date 2020/4/11 13:52
 */
@Data
public class MeetingRoom {

    private int roomId;//会议室编号
    private String roomNam;//会议室名字
    private int roomNum;//会议室门牌号
    private int capacity;//会议室容量
    private String status;//会议室状态 0：启用；1 停用；
    private String desc;//会议室描述
}
