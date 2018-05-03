package com.csu.geekspace.detectsoftware.service;

import com.csu.geekspace.detectsoftware.pojo.Result;

import java.util.Date;

/**
 * @Author xuhang
 * @date 2018/4/20 15:45
 */
public interface CalculateByTime {
    public String Calculate(Date dateStart,Date dateEnd);
}
