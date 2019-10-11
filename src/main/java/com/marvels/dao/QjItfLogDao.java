package com.marvels.dao;

import com.marvels.dto.common.QjItfLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 接口日志 dao
 * @author houyl
 */
@Mapper
public interface QjItfLogDao {
    /**
     * 日志记录
     * @param qjItfLog 参数
     * @return
     */
    int addQjItfLog(QjItfLog qjItfLog);
}
