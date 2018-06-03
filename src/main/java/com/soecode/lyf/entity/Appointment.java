package com.soecode.lyf.entity;

import java.util.Date;

/**
 * 预约图书实体
 */
public class Appointment {

    /** 图书ID */
    private long bookId;

    /** 学号 */
    private long studentId;

    /** 预约时间 */
    private Date appointTime;

    /** 图书实体（多对一的复合属性） */
    private Book book;

    public Appointment() {
    }

    public Appointment(final long bookId, final long studentId, final Date appointTime) {
        this.bookId = bookId;
        this.studentId = studentId;
        this.appointTime = appointTime;
    }

    public Appointment(final long bookId, final long studentId, final Date appointTime,
            final Book book) {
        this.bookId = bookId;
        this.studentId = studentId;
        this.appointTime = appointTime;
        this.book = book;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(final long bookId) {
        this.bookId = bookId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(final long studentId) {
        this.studentId = studentId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(final Date appointTime) {
        this.appointTime = appointTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(final Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Appointment [bookId=" + bookId + ", studentId=" + studentId + ", appointTime=" +
                appointTime + "]";
    }

}
