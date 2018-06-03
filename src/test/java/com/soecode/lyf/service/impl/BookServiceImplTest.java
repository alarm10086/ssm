package com.soecode.lyf.service.impl;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.dto.AppointExecution;
import com.soecode.lyf.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImplTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint() throws Exception {
        final long bookId = 1001;
        final long studentId = 12345678910L;
        final AppointExecution execution = bookService.appoint(bookId, studentId);
        System.out.println(execution);
    }

}
