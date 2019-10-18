package com.marvels.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.marvels.common.rabbitMQ.MsgProducer;
import com.marvels.common.enums.PublicEnums;
import com.marvels.common.util.CommonUtil;
import com.marvels.common.util.HttpUtil;
import com.marvels.common.util.PropertiesLoadUtil;
import com.marvels.dto.common.QjItfLog;
import com.marvels.dto.jf.*;
import com.marvels.service.JfApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service("jfApiService")
public class JfApiServiceImpl implements JfApiService {
    @Autowired
    private MsgProducer producer;

	@Override
	public JfResponseDto applyQuota(JfRequestDto<JfApplyQuotaReq> param) throws Exception {
		return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100171, param);
	}

    /**
     * 支持的银行卡列表查询
     * @param param 请求参数
     * @return JfResponseDto<JfQueryBankListRes>
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfQueryBankListRes> queryBankList(JfRequestDto<JfQueryBankListReq> param) throws Exception {
        return (JfResponseDto<JfQueryBankListRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100159, param);
    }

    /**
     * 卡bin查询
     * @param param 请求参数
     * @return JfResponseDto<JfQueryCardBinRes>
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfQueryCardBinRes> queryCardBin(JfRequestDto<JfQueryCardBinReq> param) throws Exception {
        return (JfResponseDto<JfQueryCardBinRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100160, param);
    }

    /**
     * 签约申请
     * @param param 请求参数
     * @return JfResponseDto<JfSignApplyRes>
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfSignApplyRes> signApply(JfRequestDto<JfSignApplyReq> param) throws Exception {
        return (JfResponseDto<JfSignApplyRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100161, param);
    }
    /**
     * 签约确认
     * @param param 请求参数
     * @return JfResponseDto<JfConfirmSignRes>
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfConfirmSignRes> confirmSign(JfRequestDto<JfConfirmSignReq> param) throws Exception {
        return (JfResponseDto<JfConfirmSignRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100162, param);
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
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100163, param);
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
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100164, param);
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
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100165, param);
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
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100166, param);
    }

    /**
     * 商户授信结果信息接收
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto saveCreditGranting(JfRequestDto param) throws Exception {
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100173, param);
    }

    /**
     * 风控设备指纹实时反欺诈
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto fgpAntiFraud(JfRequestDto param) throws Exception {
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100183, param);
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
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100167, param);
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
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100168, param);
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
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100184, param);
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
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100169, param);
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
        return this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100170, param);
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
        return (JfResponseDto<JfGetIouRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100174, param);
    }

    /**
     * 还款计划查询
     *
     * @param param 请求参数
     * @return
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfGetRepayPlanRes> getRepayPlan(JfRequestDto<JfGetIouReq> param) throws Exception {
        return (JfResponseDto<JfGetRepayPlanRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100175, param);
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
        return (JfResponseDto<JfQueryRepayAmtRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100176, param);
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
        return (JfResponseDto<JfRayRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100177, param);
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
        return (JfResponseDto<JfQueryRepayResultRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100178, param);
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
        return (JfResponseDto<JfQueryRepayRecourdRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100179, param);
    }

    /**
     * 资金路由接口
     *
     * @param request
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfCapitalRoutingRes> capitalRouting(JfRequestDto<JfCapitalRoutingReq> request) throws Exception {
        return (JfResponseDto<JfCapitalRoutingRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100150, request);
    }

    /**
     * 借款试算接口
     *
     * @param request
     * @return JfResponseDto
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfLoanTrialRes> loanTrial(JfRequestDto<JfLoanTrialReq> request) throws Exception {
        return (JfResponseDto<JfLoanTrialRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100151, request);
    }

    /**
     * 下单接口
     *
     * @param request
     * @return JfResponseDto
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfPlaceOrderRes> placeOrder(JfRequestDto<JfPlaceOrderReq> request) throws Exception {
        return (JfResponseDto<JfPlaceOrderRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100152, request);
    }

    /**
     * 资产端关单申请接口
     *
     * @param request
     * @return JfResponseDto
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfCloseOrderApplyRes> closeOrderApply(JfRequestDto<JfCloseOrderApplyReq> request) throws Exception {
        return (JfResponseDto<JfCloseOrderApplyRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100153, request);
    }

    /**
     * 工单信息查询接口
     *
     * @param request
     * @return JfResponseDto
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfQueryOrderInfoRes> queryOrderInfo(JfRequestDto<JfQueryOrderInfoReq> request) throws Exception {
        return (JfResponseDto<JfQueryOrderInfoRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100154, request);
    }

    /**
     * 资产端关单结果查询接口
     *
     * @param request
     * @return JfResponseDto
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfQueryCloseOrderRes> queryCloseOrderRes(JfRequestDto<JfQueryCloseOrderReq> request) throws Exception {
        return (JfResponseDto<JfQueryCloseOrderRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100155, request);
    }

    /**
     * 工单合同信息查询接口
     *
     * @param request
     * @return JfResponseDto
     * @throws Exception
     */
    @Override
    public JfResponseDto<JfQueryContractRes> queryContract(JfRequestDto<JfQueryOrderInfoReq> request) throws Exception {
        return (JfResponseDto<JfQueryContractRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100156, request);
    }

    @Override
	public JfResponseDto<JfQueryApplyResultRes> queryApplyResult(JfRequestDto<JfQueryApplyResultReq> param) throws Exception {
		return (JfResponseDto<JfQueryApplyResultRes>) this.sendRequest(PublicEnums.JfInterfaceCodeEnum.JF100172, param);
	}


    /**
     * 发送post请求包装方法
     * @param syinterface
     * @param param
     * @return
     */
    private JfResponseDto<?> sendRequest(PublicEnums.JfInterfaceCodeEnum syinterface, JfRequestDto<?> param) {
        String url = PropertiesLoadUtil.getPropertiesValue("api.jiufu.url", "forms-openapi.properties");
        String questParam = JSON.toJSONString(param);
        String responseStr = HttpUtil.doPostByJiuFu(syinterface.getCode(), url + syinterface.getUri(), questParam);

        // 日志入队列
        QjItfLog qjItfLog = buildQjItfLog(syinterface, questParam, responseStr);
        if(qjItfLog != null) {
            // 队列
            producer.sendMsg(JSONObject.toJSONString(qjItfLog));
        }
        return JSON.parseObject(responseStr, JfResponseDto.class);
    }

    /**
     * 构建日志对象
     * @param enums  枚举
     * @param inParam  记录入参
     * @param outParam 记录出参
     * @return
     */
    private QjItfLog buildQjItfLog(PublicEnums.JfInterfaceCodeEnum enums,String inParam,String outParam) {
        if(CommonUtil.validEmpty(enums.getCode())) {
            return null;
        }

        // 接口日志入口
        QjItfLog qjItfLog = new QjItfLog();
        qjItfLog.setItfCode(enums.getCode());
        qjItfLog.setItfName(enums.getDesc());
        qjItfLog.setItfUri(enums.getUri());
        qjItfLog.setInParam(JSONObject.toJSONString(inParam));
        qjItfLog.setOutParam(JSONObject.toJSONString(outParam));
        return qjItfLog;
    }
}
