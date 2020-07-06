package com.zucc.wsxbl.demo.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTransform {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");

    public String date2String(Date date) {
        return sdf.format(date);
    }

    public Date string2Date(String str) {
        Date date = null;

        date = java.sql.Date.valueOf(str);

        return date;
    }

    public String timestamp2String(Timestamp ts) {
        String str = "";
        try {
            str = sdf.format(ts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public Timestamp string2Timestamp(String str) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        try {
            ts = Timestamp.valueOf(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ts;
    }
}
