package com.nuc.lg.ibeacon.DateTest;


import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SqlDateTest {

    @org.junit.Test
    public void date() {
        String dateString = "2018-05-01";
        Date date = Date.valueOf(dateString);
        System.out.println(date);
    }

    @org.junit.Test
    public void tumpToDate() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        try {
            Long time = new Long("1527069681000");
            Date date = new Date(time);
            String dateStr = sdf.format(date);
            System.out.println(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
