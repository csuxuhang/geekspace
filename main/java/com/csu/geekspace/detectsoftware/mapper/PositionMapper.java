package com.csu.geekspace.detectsoftware.mapper;

import com.csu.geekspace.detectsoftware.pojo.Position;
import com.csu.geekspace.detectsoftware.pojo.PositionKey;

public interface PositionMapper {
    int deleteByPrimaryKey(PositionKey key);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(PositionKey key);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}