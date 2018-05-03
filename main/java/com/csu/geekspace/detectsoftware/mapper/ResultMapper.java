package com.csu.geekspace.detectsoftware.mapper;

import com.csu.geekspace.detectsoftware.pojo.Result;
import com.csu.geekspace.detectsoftware.pojo.ResultKey;

public interface ResultMapper {
    int deleteByPrimaryKey(ResultKey key);

    int insert(Result record);

    int insertSelective(Result record);

    Result selectByPrimaryKey(ResultKey key);

    int updateByPrimaryKeySelective(Result record);

    int updateByPrimaryKey(Result record);
}