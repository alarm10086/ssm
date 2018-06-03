package com.soecode.lyf.entity;

/**
 * 图书实体
 */
public class Book {

    /** 图书ID */
    private long bookId;

    /** 图书名称 */
    private String name;

    /** 馆藏数量 */
    private int number;

    public Book() {
    }

    public Book(final long bookId, final String name, final int number) {
        this.bookId = bookId;
        this.name = name;
        this.number = number;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(final long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", name=" + name + ", number=" + number + "]";
    }
}
