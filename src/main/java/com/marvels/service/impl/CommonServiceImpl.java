package com.marvels.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marvels.dao.ApiLogDao;
import com.marvels.dto.common.ApiLog;
import com.marvels.service.CommonService;

/**
 * 记录接口日志
 * @author houyl
 * @date 2019/10/11 10:33
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {

    @Autowired
    private ApiLogDao apiLogDao;

    /**
     * 玖富记录接口日志
     *
     * @param qjItfLog
     */
    @Override
    public void saveApiLog(ApiLog apiLog) {
    	apiLogDao.addApiLog(apiLog);
    }
}
