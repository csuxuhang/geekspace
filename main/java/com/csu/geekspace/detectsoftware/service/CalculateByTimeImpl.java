package com.csu.geekspace.detectsoftware.service;

import com.csu.geekspace.detectsoftware.Exception.MyException;
import com.csu.geekspace.detectsoftware.enums.OutcomeEnum;
import com.csu.geekspace.detectsoftware.mapper.DataMapper;
import com.csu.geekspace.detectsoftware.mapper.ResultMapper;
import com.csu.geekspace.detectsoftware.pojo.Data;
import com.csu.geekspace.detectsoftware.pojo.Result;
import com.csu.geekspace.detectsoftware.utils.CheckYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author xuhang
 * @date 2018/4/20 15:49
 */

@Service
@Transactional
public class CalculateByTimeImpl implements CalculateByTime {


    @Autowired
    private DataMapper dataMapper;
    @Autowired
    private ResultMapper resultMapper;

    //计算单个测点单个频率某时间下的E值
    public BigDecimal CalculateE(Data data){
        if (StringUtils.isEmpty(data)){
            throw new MyException(OutcomeEnum.DATA_IS_NULL);
        }
        BigDecimal U = data.getU();
        BigDecimal I = data.getI();
        if (I == new BigDecimal(0)){throw new MyException(OutcomeEnum.I_IS_ZERO);}
        return U.divide(I,6,BigDecimal.ROUND_HALF_UP);
    }

    //计算单个测点单个频率某时间下的η值
    public BigDecimal Calculate2(Data data){
        if (StringUtils.isEmpty(data)){
            throw new MyException(OutcomeEnum.DATA_IS_NULL);
        }
        BigDecimal Ei = CalculateE(data);
        Data dataJ = dataMapper.selectByLastTime(data);
        if (StringUtils.isEmpty(dataJ)){return new BigDecimal(10000);}
        BigDecimal Ej = CalculateE(dataJ);
        return (Ei.subtract(Ej)).multiply(new BigDecimal(100)).divide(Ej,6,BigDecimal.ROUND_HALF_UP);
    }

    //计算单个测点单个频率某时间下的ζ值
    public BigDecimal Calculate3(Data data){
        if (StringUtils.isEmpty(data)){
            throw new MyException(OutcomeEnum.DATA_IS_NULL);
        }
        BigDecimal Ei = CalculateE(data);
        //获取采集时间
        Date dateI = data.getT();

        Data dataLast = dataMapper.selectByLastTime(data);
        if (StringUtils.isEmpty(dataLast)){return new BigDecimal(10000);}
        BigDecimal Ej = CalculateE(dataLast);
        Date dateJ = dataLast.getT();

        //判断是否是整除4的非闰年
        Date dateCi = CheckYear.tranDate(dateI);
        Date dateCj = CheckYear.tranDate(dateJ);
        //计算两次测量之间间隔的小时数
        //转化成毫秒值
        Long timeI = dateCi.getTime();
        Long timeJ = dateCj.getTime();
        Long time = (timeI - timeJ)/1000/60/60;
        BigDecimal timeFinal = new BigDecimal(time);
        return (Ei.subtract(Ej)).multiply(new BigDecimal(100)).divide(timeFinal,6,BigDecimal.ROUND_HALF_UP).divide(Ej,6,BigDecimal.ROUND_HALF_UP);
    }

    //计算单个测点单个频率某时间下的ξ值
    public BigDecimal Calculate4(Data data){
        if (StringUtils.isEmpty(data)){
            throw new MyException(OutcomeEnum.DATA_IS_NULL);
        }
        BigDecimal Ei = CalculateE(data);
        //获取采集时间
        Date dateI = data.getT();

        Data dataLast = dataMapper.selectByLastTime(data);
        if (StringUtils.isEmpty(dataLast)){return new BigDecimal(10000);}
        BigDecimal Ej = CalculateE(dataLast);
        Date dateJ = dataLast.getT();

        //判断是否是整除4的非闰年
        Date dateCi = CheckYear.tranDate(dateI);
        Date dateCj = CheckYear.tranDate(dateJ);

        //转化成毫秒值
        Long timeI = dateCi.getTime();
        Long timeJ = dateCj.getTime();
        //计算两次测量之间间隔的小时数
        Long time = (timeI - timeJ)/1000/60/60;
        BigDecimal timeFinal = new BigDecimal(time);
        Double eij = (Math.log10(Ei.doubleValue())-Math.log10(Ej.doubleValue()));
        BigDecimal e =new BigDecimal(eij);
        return e.multiply(new BigDecimal(100)).divide(timeFinal,6,BigDecimal.ROUND_HALF_UP);
    }

    public  Result trans(Data data){
        Result result = new Result();
        result.setData_position_area(data.getPosition_area());
        result.setData_position_line(data.getPosition_line());
        result.setData_position_station(data.getPosition_station());
        result.setData_f(data.getF());
        result.setData_t(data.getT());
        BigDecimal E = CalculateE(data);
        BigDecimal η = Calculate2(data);
        BigDecimal ζ = Calculate3(data);
        BigDecimal ξ = Calculate4(data);
        result.setΕ(E);
        result.setΗ(η);
        result.setΖ(ζ);
        result.setΞ(ξ);
        return result;
    }

    @Override
    public String Calculate(Date dateStart, Date dateEnd) {
            List<Data> dataList = dataMapper.selectByDateTime(dateStart,dateEnd);
            int sum = 0;
            for (Data data:dataList){
                if (data!=null){
                    Result result = trans(data);

                    if (resultMapper.selectByPrimaryKey(result)==null){
                        int r = resultMapper.insert(result);
                        sum += r;
                    }else{
                        int k = resultMapper.updateByPrimaryKey(result);
                        sum += k;
                    }
                }
            }
            if (sum!=0){return "插入成功";}
            else {return "插入失败";}
    }
}
