package com.csu.geekspace.detectsoftware.mapper;

import com.csu.geekspace.detectsoftware.pojo.Data;
import com.csu.geekspace.detectsoftware.pojo.DataKey;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DataMapper {
    int deleteByPrimaryKey(DataKey key);

    int insert(Data record);

    int insertSelective(Data record);

    Data selectByPrimaryKey(DataKey key);

    //得到该频点下上一次测量的数据
    Data selectByLastTime(Data data);

    //根据起始和结束日期查询数据
    List<Data> selectByDateTime(@Param("dateStart") Date dateStart, @Param("dateEnd") Date dateEnd);


    int updateByPrimaryKeySelective(Data record);

    int updateByPrimaryKey(Data record);
}