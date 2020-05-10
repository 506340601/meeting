package com.cusft.lsl.meeting.support;

/**
 * 封装成字符串对象
 * @author Long
 * @Date 2020/4/23 1:26
 */
public class SimpleResponse {

    private Object contend;

    public SimpleResponse(Object contend) {
        this.contend = contend;
    }

    public Object getContend() {
        return contend;
    }

    public void setContend(Object contend) {
        this.contend = contend;
    }
}
