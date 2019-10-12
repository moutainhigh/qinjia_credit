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
     * 记录接口日志（异步）
     *
     * @param itfCode  接口编码（枚举InterfaceCodeEnum）
     * @param inParam  记录入参
     * @param outParam 记录出参
     */
    @Override
    @Async("asyncPromiseExecutor")
    public void inOutParamsItfLog(String itfCode, Object inParam, Object outParam) {
        log.info(String.format("接口日志调用：itfCode=【{}】，inParam=【{}】，outParam=【{}】",itfCode,inParam,outParam));
        if(CommonUtil.validEmpty(itfCode)) {
            log.error("接口编码为空");
            return;
        }

        // 接口名称
        String itfName = Enum.valueOf(PublicEnums.InterfaceCodeEnum.class, itfCode).getDesc();
        String in = JSONObject.toJSONString(inParam);
        String out = JSONObject.toJSONString(outParam);

        // 接口日志入口
        QjItfLog qjItfLog = new QjItfLog();
        qjItfLog.setItfCode(itfCode);
        qjItfLog.setItfName(itfName);
        qjItfLog.setInParam(in);
        qjItfLog.setOutParam(out);
        qjItfLogDao.addQjItfLog(qjItfLog);
    }
}
