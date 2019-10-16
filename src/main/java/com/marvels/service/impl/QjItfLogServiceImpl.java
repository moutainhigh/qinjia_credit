package com.marvels.service.impl;

import com.marvels.dao.QjItfLogDao;
import com.marvels.dto.common.QjItfLog;
import com.marvels.service.QjItfLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 记录接口日志
 * @author houyl
 * @date 2019/10/11 10:33
 */
@Service("qjItfLogService")
public class QjItfLogServiceImpl implements QjItfLogService {

    @Autowired
    private QjItfLogDao qjItfLogDao;

    /**
     * 玖富记录接口日志
     *
     * @param qjItfLog
     */
    @Override
    public void inOutParamsItfLog(QjItfLog qjItfLog) {
        qjItfLogDao.addQjItfLog(qjItfLog);
    }
}
