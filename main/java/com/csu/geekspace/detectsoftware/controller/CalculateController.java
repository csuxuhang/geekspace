package com.csu.geekspace.detectsoftware.controller;

import com.csu.geekspace.detectsoftware.enums.OutcomeEnum;
import com.csu.geekspace.detectsoftware.pojo.Outcome;
import com.csu.geekspace.detectsoftware.service.CalculateByTime;
import com.csu.geekspace.detectsoftware.utils.OutcomeUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author xuhang
 * @date 2018/4/26 23:52
 */
@RestController
@CrossOrigin
public class CalculateController {

    @Autowired
    private CalculateByTime calculateByTime;

    @ApiOperation(value = "计算时间段内的数据并存入数据库",notes = "计算时间段内的数据并存入数据库，上传起始时间和结束时间")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "String",name = "dateStart",value = "起始日期",paramType = "query",required = true),
            @ApiImplicitParam(dataType = "String",name = "dateEnd",value = "结束日期",paramType = "query",required = true)
    })
    @PostMapping(value = "/calculate")
    public Outcome calculateViaTime (@RequestParam(value = "dateStart") String dateStart,@RequestParam(value = "dateEnd") String dateEnd) throws ParseException {
        if (dateStart != null && dateStart !="" && dateEnd != null && dateEnd !=""){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dateS = dateFormat.parse(dateStart);
            Date dateE = dateFormat.parse(dateEnd);
            String result = calculateByTime.Calculate(dateS,dateE);
            if (result.equals("插入成功")){
                return OutcomeUtil.success(OutcomeEnum.SUCCESS);
            }
        }
        return OutcomeUtil.error(OutcomeEnum.INSERT_DEFEATED);
    }
}
