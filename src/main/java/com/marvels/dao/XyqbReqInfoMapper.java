package com.marvels.dao;

import com.marvels.dto.common.XyqbReqInfo;

public interface XyqbReqInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(XyqbReqInfo record);

    int insertSelective(XyqbReqInfo record);

    XyqbReqInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(XyqbReqInfo record);

    int updateByPrimaryKey(XyqbReqInfo record);
}