package com.csu.geekspace.detectsoftware.service;

import com.csu.geekspace.detectsoftware.mapper.DataMapper;
import com.csu.geekspace.detectsoftware.mapper.ResultMapper;
import com.csu.geekspace.detectsoftware.pojo.Data;
import com.csu.geekspace.detectsoftware.pojo.Result;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * @Author xuhang
 * @date 2018/4/25 19:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CalculateByTimeImplTest {

    @Autowired
    private DataMapper dataMapper;
    @Autowired
    private ResultMapper resultMapper;
    @Autowired
    private CalculateByTimeImpl calculateByTime;

    @Test
    public void calculate() throws Exception {

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateStart = dateformat.parse("1900-01-01 00:00:00");
        Date dateEnd = dateformat.parse("1900-01-02 00:00:00");
        SimpleDateFormat sf = new SimpleDateFormat("YYYY");
        String year = sf.format(dateStart);
        int y = Integer.parseInt(year);
/*        String solution = calculateByTime.Calculate(dateformat.format(dateStart),dateformat.format(dateEnd));
        Assert.assertEquals(new String("插入成功"),solution);*/
        /*Data data = new Data();
        data.setPosition_area("Area");
        data.setPosition_line(900);
        data.setPosition_station(200);
//        Double f = new Double(0.09375);
//        data.setF(String.valueOf(f));
        data.setF("0.09375");
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateStart = dateformat.parse("1900-01-02 00:00:00");
        data.setT(dateStart);
        data.setI(new BigDecimal(13.395));
        data.setU(new BigDecimal(59.01865));
        data.setErr(new BigDecimal(7.04));
        System.out.println(data.toString());
        Data data1 = dataMapper.selectByLastTime(data);
        System.out.println(data1.toString());*/

//        List<Data> dataList = dataMapper.selectByDateTime(dateStart, dateEnd);
//        for (Data data : dataList) {
//            Data data1 = dataMapper.selectByLastTime(data);
//            System.out.println(data1);
//        }
        /*SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateStart = dateformat.parse("1899-12-31 00:00:00");
        Date dateEnd = dateformat.parse("1900-01-02 00:00:00");*/
        /*String solution = calculateByTime.Calculate(dateStart,dateEnd);*/
        /*List<Data> dataList = dataMapper.selectByDateTime(dateStart, dateEnd);
        for (Data data : dataList) {
            if (data != null) {
                Result result = Trans.trans(data);
                System.out.println(result);
            }
        }*/
        }
    }

