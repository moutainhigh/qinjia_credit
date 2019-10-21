package com.marvels.dao;

import org.apache.ibatis.annotations.Mapper;

import com.marvels.dto.common.ApiLog;

/**
 * 接口日志 dao
 * @author houyl
 */
@Mapper
public interface ApiLogDao {
    /**
     * 日志记录
     * @param qjItfLog 参数
     * @return
     */
    int addApiLog(ApiLog qjItfLog);
}
