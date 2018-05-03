/*
package com.csu.geekspace.detectsoftware.utils;

import com.csu.geekspace.detectsoftware.Exception.MyException;
import com.csu.geekspace.detectsoftware.enums.OutcomeEnum;
import com.csu.geekspace.detectsoftware.mapper.DataMapper;
import com.csu.geekspace.detectsoftware.pojo.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.math.BigDecimal;

*/
/**
 * 根据Data计算Result的各个值
 * @Author xuhang
 * @date 2018/4/18 11:19
 *//*

@Component
public class Calculate {

    @Autowired
    private DataMapper dataMapper;


    //计算单个测点单个频率某时间下的E值
    public BigDecimal CalculateE(Data data){
        if (StringUtils.isEmpty(data)){
            throw new MyException(OutcomeEnum.DATA_IS_NULL);
        }
        BigDecimal U = data.getU();
        BigDecimal I = data.getI();
        if (I == new BigDecimal(0)){throw new MyException(OutcomeEnum.I_IS_ZERO);}
        return U.divide(I,4,BigDecimal.ROUND_HALF_UP);
    }

    //计算单个测点单个频率某时间下的η值
    public BigDecimal Calculate2(Data data){
        if (StringUtils.isEmpty(data)){
            throw new MyException(OutcomeEnum.DATA_IS_NULL);
        }
        BigDecimal Ei = CalculateE(data);
        Data dataJ = dataMapper.selectByLastTime(data);
        if (StringUtils.isEmpty(dataJ)){return new BigDecimal(-1);}
        BigDecimal Ej = CalculateE(dataJ);
        return Ei.subtract(Ej).divide(Ej,4,BigDecimal.ROUND_HALF_UP);
    }

    //计算单个测点单个频率某时间下的ζ值
    public BigDecimal Calculate3(Data data){
        if (StringUtils.isEmpty(data)){
            throw new MyException(OutcomeEnum.DATA_IS_NULL);
        }
        BigDecimal Ei = CalculateE(data);
        //获取采集时间
        Date dateI = data.getT();
        //转化成毫秒值
        Long timeI = dateI.getTime();

        Data dataLast = dataMapper.selectByLastTime(data);
        if (StringUtils.isEmpty(dataLast)){return new BigDecimal(-1);}
        BigDecimal Ej = CalculateE(dataLast);
        Date dateJ = dataLast.getT();
        Long timeJ = dateJ.getTime();
        //计算两次测量之间间隔的分钟数
        Long time = (timeI - timeJ)/1000/60;
        BigDecimal timeFinal = new BigDecimal(time);
        return Ei.subtract(Ej).divide(timeFinal).divide(Ej,4,BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal Calculateξ(Data data){
        if (StringUtils.isEmpty(data)){
            throw new MyException(OutcomeEnum.DATA_IS_NULL);
        }
        BigDecimal Ei = CalculateE(data);
        //获取采集时间
        Date dateI = data.getT();
        //转化成毫秒值
        Long timeI = dateI.getTime();

        Data dataLast = dataMapper.selectByLastTime(data);
        if (StringUtils.isEmpty(dataLast)){return new BigDecimal(-1);}
        BigDecimal Ej = CalculateE(dataLast);
        Date dateJ = dataLast.getT();
        Long timeJ = dateJ.getTime();
        //计算两次测量之间间隔的分钟数
        Long time = (timeI - timeJ)/1000/60;
        BigDecimal timeFinal = new BigDecimal(time);
        Double eij = Math.log10(Ei.divide(Ej).doubleValue());
        BigDecimal e =new BigDecimal(eij);
        return e.divide(timeFinal,4,BigDecimal.ROUND_HALF_UP);
    }


}
*/
