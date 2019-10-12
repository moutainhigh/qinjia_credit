package com.marvels.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.marvels.common.enums.PublicEnums;
import com.marvels.common.util.CommonUtil;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.dao.QjItfLogDao;
import com.marvels.dto.common.QjItfLog;
import com.marvels.service.QjItfLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 记录接口日志
 * @author houyl
 * @date 2019/10/11 10:33
 */
@Service("qjItfLogService")
public class QjItfLogServiceImpl implements QjItfLogService {
    /** 日志 */
    private MarvelsLogUtil log = MarvelsLogUtil.getInstance();

    @Autowired
    private QjItfLogDao qjItfLogDao;

    /**
     * 玖富记录接口日志（异步）
     *
     * @param enums  枚举
     * @param inParam  记录入参
     * @param outParam 记录出参
     */
    @Override
    @Async("asyncPromiseExecutor")
    public void inOutParamsItfLog(PublicEnums.JfInterfaceCodeEnum enums, Object inParam, Object outParam) {
        log.info(String.format("接口日志调用：itfCode=【{}】，inParam=【{}】，outParam=【{}】",enums.getCode(),inParam,outParam));
        if(CommonUtil.validEmpty(enums.getCode())) {
            log.error("接口编码为空");
            return;
        }

        // 接口名称
        String in = JSONObject.toJSONString(inParam);
        String out = JSONObject.toJSONString(outParam);

        // 接口日志入口
        QjItfLog qjItfLog = new QjItfLog();
        qjItfLog.setItfCode(enums.getCode());
        qjItfLog.setItfName(enums.getDesc());
        qjItfLog.setItfUri(enums.getUri());
        qjItfLog.setInParam(in);
        qjItfLog.setOutParam(out);
        qjItfLogDao.addQjItfLog(qjItfLog);
    }

    /**
     * 盛银记录接口日志（异步）
     *
     * @param enums  枚举
     * @param inParam  记录入参
     * @param outParam 记录出参
     */
    @Override
    @Async("asyncPromiseExecutor")
    public void inOutParamsItfLog(PublicEnums.SyInterfaceCodeEnum enums, Object inParam, Object outParam) {
        log.info(String.format("接口日志调用：itfCode=【{}】，inParam=【{}】，outParam=【{}】",enums.getCode(),inParam,outParam));
        if(CommonUtil.validEmpty(enums.getCode())) {
            log.error("接口编码为空");
            return;
        }

        // 接口名称
        String in = JSONObject.toJSONString(inParam);
        String out = JSONObject.toJSONString(outParam);

        // 接口日志入口
        QjItfLog qjItfLog = new QjItfLog();
        qjItfLog.setItfCode(enums.getCode());
        qjItfLog.setItfName(enums.getDesc());
        qjItfLog.setItfUri(enums.getUri());
        qjItfLog.setInParam(in);
        qjItfLog.setOutParam(out);
        qjItfLogDao.addQjItfLog(qjItfLog);
    }
}
