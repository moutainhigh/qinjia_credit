package com.marvels.controller;

import com.marvels.dto.jf.*;
import com.marvels.service.JfApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对接玖富资金方-下单业务接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping
public class JiuFuOrderController extends BaseController{

    @Autowired
    private JfApiService jfApiService;

    /**
     * 资金路由接口
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    @RequestMapping("credit/jf/ITF00012")
    public JfResponseDto capitalRouting(@RequestBody JfRequestDto<JfCapitalRoutingReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.capitalRouting(request);
    }

    /**
     * 借款试算接口
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    @RequestMapping("credit/jf/ITF00012")
    public JfResponseDto loanTrial(@RequestBody JfRequestDto<JfLoanTrialReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.loanTrial(request);
    }

    /**
     * 下单接口
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    @RequestMapping("credit/jf/ITF00012")
    public JfResponseDto placeOrder(@RequestBody JfRequestDto<JfPlaceOrderReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.placeOrder(request);
    }

    /**
     * 资产端关单申请接口
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    @RequestMapping("credit/jf/ITF00012")
    public JfResponseDto closeOrderApply(@RequestBody JfRequestDto<JfCloseOrderApplyReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.closeOrderApply(request);
    }

    /**
     * 工单信息查询接口
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    @RequestMapping("credit/jf/ITF00012")
    public JfResponseDto queryOrderInfo(@RequestBody JfRequestDto<JfQueryOrderInfoReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.queryOrderInfo(request);
    }

    /**
     * 资产端关单结果查询接口
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    @RequestMapping("credit/jf/ITF00012")
    public JfResponseDto queryCloseOrderRes(@RequestBody JfRequestDto<JfQueryCloseOrderResReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.queryCloseOrderRes(request);
    }

    /**
     * 工单合同信息查询接口
     * @return JfResponseDto
     * @throws Exception
     * @param request
     */
    @RequestMapping("credit/jf/ITF00012")
    public JfResponseDto queryContract(@RequestBody JfRequestDto<JfQueryOrderInfoReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.queryContract(request);
    }
}
