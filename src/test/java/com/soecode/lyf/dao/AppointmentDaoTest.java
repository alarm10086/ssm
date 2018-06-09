package com.soecode.lyf.dao;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentDaoTest extends BaseTest {

    @Autowired
    private AppointmentDao appointmentDao;

    @Test
    public void testAppointmentDao() throws Exception {
        testInsertAppointment();
        testQueryByKeyWithBook();
    }

    private void testInsertAppointment() throws Exception {
        final long bookId = 1000;
        final long studentId = 12345678910L;
        final int insert = appointmentDao.insertAppointment(bookId, studentId);
        System.out.println("insert=" + insert);
    }

    private void testQueryByKeyWithBook() throws Exception {
        final long bookId = 1000;
        final long studentId = 12345678910L;
        final Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
        System.out.println(appointment);
        System.out.println(appointment.getBook());
    }

}
