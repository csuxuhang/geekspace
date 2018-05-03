package com.csu.geekspace.detectsoftware.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author xuhang
 * @date 2018/4/27 15:27
 */
public class CheckYear {
    public static Date tranDate(Date date){

        Date dateReturn = date;
        SimpleDateFormat sf = new SimpleDateFormat("YYYY");
        String year = sf.format(date);

        int y = Integer.parseInt(year);

        if(y%4==0&&y%400!=0){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.YEAR , 5);
            dateReturn = calendar.getTime();
        }
        return dateReturn;
    }
}
