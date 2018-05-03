/*
package com.csu.geekspace.detectsoftware.utils;

import com.csu.geekspace.detectsoftware.pojo.Data;
import com.csu.geekspace.detectsoftware.pojo.Result;

import java.math.BigDecimal;
import java.text.ParseException;

*/
/**
 * 转换计算后的Data为Result
 * @Author xuhang
 * @date 2018/4/20 13:34
 *//*

public class Trans {
    public static Result trans(Data data){
        Result result = new Result();
        result.setData_position_area(data.getPosition_area());
        result.setData_position_line(data.getPosition_line());
        result.setData_position_station(data.getPosition_station());
        result.setData_f(data.getF());
        result.setData_t(data.getT());
        Calculate calculate = new Calculate();
        BigDecimal E = calculate.CalculateE(data);
        BigDecimal η = calculate.Calculate2(data);
        BigDecimal ζ = calculate.Calculate3(data);
        BigDecimal ξ = calculate.Calculate4(data);
        result.setΕ(E);
        result.setΗ(η);
        result.setΖ(ζ);
        result.setΞ(ξ);
        return result;
    }
}
*/
