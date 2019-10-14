package com.marvels.service.impl;

import com.marvels.dto.jf.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.marvels.common.enums.PublicEnums;
import com.marvels.common.util.HttpUtil;
import com.marvels.common.util.PropertiesLoadUtil;
import com.marvels.service.JfApiService;
import com.marvels.service.QjItfLogService;
import org.springframework.stereotype.Service;

@Service("jfApiService")
public class JfApiServiceImpl implements JfApiService {

    @Autowired
    private QjItfLogService qjItfLogService;

    /**
     * 发送post请求包装方法
     * @param syinterface
     * @param param
     * @return
     */
    private JfResponseDto<?> sendRequest(PublicEnums.JfInterfaceCodeEnum syinterface, JfRequestDto<?> param) {
        String url = PropertiesLoadUtil.getPropertiesValue("api.jiufu.url", "forms-openapi.properties");
        String questParam = JSON.toJSONString(param);
        String responseStr = HttpUtil.doPost(url + syinterface.getUri(), questParam);
        qjItfLogService.inOutParamsItfLog(syinterface,questParam,responseStr);
        return JSON.parseObject(responseStr, JfResponseDto.class);
    }

	@Override
	public JfResponseDto applyQuota(JfRequestDto<JfApplyQuotaReq> param) throws Exception {
		return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
	}

    @Override
    public JfResponseDto<JfQueryBankListRes> queryBankList(JfRequestDto<JfQueryBankListReq> param) throws Exception {
        return (JfResponseDto<JfQueryBankListRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    @Override
    public JfResponseDto<JfQueryCardBinRes> queryCardBin(JfRequestDto<JfQueryCardBinReq> param) throws Exception {
        return (JfResponseDto<JfQueryCardBinRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    @Override
    public JfResponseDto<JfQueryAuthCardRes> queryAuthCard(JfRequestDto<JfQueryAuthCardReq> param) throws Exception {
        return (JfResponseDto<JfQueryAuthCardRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    @Override
    public JfResponseDto<JfSignApplyRes> signApply(JfRequestDto<JfSignApplyReq> param) throws Exception {
        return (JfResponseDto<JfSignApplyRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    @Override
    public JfResponseDto<JfConfirmSignRes> confirmSign(JfRequestDto<JfConfirmSignReq> param) throws Exception {
        return (JfResponseDto<JfConfirmSignRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    /**
     * 实名认证
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto authName(JfRequestDto param) throws Exception {
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF5501, param);
    }

    /**
     * 人脸识别结果上传
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto faceRecogSave(JfRequestDto param) throws Exception {
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF5503, param);
    }

    /**
     * KYC信息提交
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto saveCustomerKyc(JfRequestDto param) throws Exception {
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF5504, param);
    }

    /**
     * 客户基本信息查询
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto getCustomerBaseInfo(JfRequestDto param) throws Exception {
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF5526, param);
    }

    /**
     * 用于个人信息查询-基于身份证号码
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto getCustomerBaseInfoByIdNo(JfRequestDto param) throws Exception {
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF5527, param);
    }

    /**
     * 银行卡鉴权
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto authBankCard(JfRequestDto param) throws Exception {
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF5507, param);
    }

    /**
     * 运营商授权
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto authOperator(JfRequestDto param) throws Exception {
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF5511, param);
    }

    /**
     * 信用卡授权
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto authCreditCard(JfRequestDto param) throws Exception {
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF5514, param);
    }

    /**
     * 绑卡列表查询
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto queryBankCard(JfRequestDto param) throws Exception {
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF5518, param);
    }

    /**
     * 授信项状态查询
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto queryCreditStatus(JfRequestDto param) throws Exception {
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF5519, param);
    }

    /**
     * 商户接收授权结果
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto callBackAuth(JfRequestDto param) throws Exception {
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF5524, param);
    }

    /**
     * 交易绑卡落库
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto changeCard(JfRequestDto param) throws Exception {
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF5528, param);
    }

    /**
     * 借据编号查询借据信息
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfGetIouRes> getIou(JfRequestDto<JfGetIouReq> param) throws Exception {
        return (JfResponseDto<JfGetIouRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    /**
     * 查询用户所有的借据
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfGetIouByCustNoRes> getIouByCustNo(JfRequestDto<JfGetIouByCustNoReq> param) throws Exception {
        return (JfResponseDto<JfGetIouByCustNoRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    /**
     * 还款计划查询
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfGetRepayPlanRes> getRepayPlan(JfRequestDto<JfGetRepayPlanReq> param) throws Exception {
        return (JfResponseDto<JfGetRepayPlanRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    /**
     * 还款金额试算
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfQueryRepayAmtRes> queryRepayAmt(JfRequestDto<JfQueryRepayAmtReq> param) throws Exception {
        return (JfResponseDto<JfQueryRepayAmtRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    /**
     * 主动还款
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfRayRes> repay(JfRequestDto<JfRayReq> param) throws Exception {
        return (JfResponseDto<JfRayRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    /**
     * 扣款结果查询
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfQueryRepayResultRes> queryRepayResult(JfRequestDto<JfQueryRepayResultReq> param) throws Exception {
        return (JfResponseDto<JfQueryRepayResultRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }

    /**
     * 查询用户还款记录
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfQueryRepayRecourdRes> queryRepayRecord(JfRequestDto<JfQueryRepayRecourdReq> param) throws Exception {
        return (JfResponseDto<JfQueryRepayRecourdRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF700005, param);
    }
}
