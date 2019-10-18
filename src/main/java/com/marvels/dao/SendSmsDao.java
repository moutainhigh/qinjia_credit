package com.marvels.dao;

import com.marvels.dto.common.SendSms;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName SendSmsDao
 * @Description TODO
 * @Author renyz
 * @Date 2019/10/18 16:41
 * @Version 1.0
 **/
@Mapper
public interface SendSmsDao {
    /**
     * 短信发送记录
     * @param sendSms 参数
     * @return
     */
    int addSendSms(SendSms sendSms);
}
