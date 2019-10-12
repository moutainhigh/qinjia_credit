package com.marvels.service;


import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;

/**
 * 玖富接口调用service
 */
public interface JiuFuPayService {
    /**
     * 支持的银行卡列表查询
     * @return
     * @throws Exception
     */
    JfResponseDto queryBankList(JfRequestDto request) throws Exception;
    /**
     * 卡bin查询
     * @return
     * @throws Exception
     */
    JfResponseDto queryCardBin(JfRequestDto request) throws Exception;
    /**
     * 鉴权查询
     * @return
     * @throws Exception
     */
    JfResponseDto queryAuthCard(JfRequestDto request) throws Exception;
    /**
     * 签约申请
     * @return
     * @throws Exception
     */
    JfResponseDto signApply(JfRequestDto request) throws Exception;

    /**
     * 签约确认
     * @return
     * @throws Exception
     */
    JfResponseDto confirmSign(JfRequestDto request) throws Exception;

    /**
     *
     * @param request
     * @return
     * @throws Exception
     */
    JfResponseDto getResult(JfRequestDto request,String enums) throws Exception;
}
