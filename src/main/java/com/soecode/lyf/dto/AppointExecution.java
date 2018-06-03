package com.soecode.lyf.dto;

import com.soecode.lyf.entity.Appointment;
import com.soecode.lyf.enums.AppointStateEnum;

/**
 * 封装预约执行后结果
 */
public class AppointExecution {

    /** 图书ID */
    private long bookId;

    /** 预约结果状态码 */
    private int state;

    /** 预约结果状态信息 */
    private String stateInfo;

    /** 预约成功对象 */
    private Appointment appointment;

    public AppointExecution() {
    }

    /** 预约失败的构造器 */
    public AppointExecution(final long bookId, final AppointStateEnum stateEnum) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    /** 预约成功的构造器 */
    public AppointExecution(final long bookId, final AppointStateEnum stateEnum,
            final Appointment appointment) {
        this.bookId = bookId;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.appointment = appointment;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(final long bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(final int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(final String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(final Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "AppointExecution [bookId=" + bookId + ", state=" + state + ", stateInfo=" +
                stateInfo + ", appointment="
                + appointment + "]";
    }

}
