package com.marvels.controller;

import com.marvels.common.enums.XyqbCodeAndUrlEnum;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.common.util.chuangjin.CjReqUtil;
import com.marvels.common.util.chuangjin.util.CJRequestDto;
import com.marvels.common.util.hexj.dto.PaymentInfoHeader;
import com.marvels.dto.common.ReturnCode;
import com.marvels.dto.hexj.response.ReqToHaierResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: marvels-open-plateform
 * @description: LP20002, LP30001, LP30002, LP30003
 * @author: xiaohai
 * @create: 2019-08-29 20:19
 **/
@RestController
@RequestMapping
public class HaierMetaphaseController {
    @Autowired
    private PaymentInfoService paymentInfoService;
    @Autowired
    private InitiativeRepaymentService repaymentService;

    /**
     * 【LP20002】现金贷支用信息保存
     *
     * @param requestDto
     * @return PaymentInfoReq paymentInfoReq
     * @author sch
     */
    @RequestMapping("loan/LP20002")
    public ReqToHaierResultDto paymentInfoLP20002(@RequestBody CJRequestDto requestDto) {
        try {
            PaymentInfoReq paymentInfoReq = new PaymentInfoReq();
            PaymentInfoBody paymentInfoBody = CjReqUtil.decrypt(requestDto, PaymentInfoBody.class);
            paymentInfoReq.setPaymentInfoBody(paymentInfoBody);
            PaymentInfoHeader paymentInfoHeader = new PaymentInfoHeader(XyqbCodeAndUrlEnum.LP20002.getCode(),
                    paymentInfoBody.getAutoFlag(), paymentInfoBody.getTradeType());
            paymentInfoReq.setPaymentInfoHeader(paymentInfoHeader);
            return paymentInfoService.paymentInfoLP20002(paymentInfoReq);
        } catch (Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP20002】支用信息保存异常", e);
            return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR, "发生异常");
        }
    }

    /**
     * 【LP30001】主动还款相关接口 试算
     *  InitiativeRepaymentReq repaymentReq
     * @param requestDto
     * @return
     * @author sch
     */
    @RequestMapping("loan/LP30001")
    public ReqToHaierResultDto estimateRepayLP30001(@RequestBody CJRequestDto requestDto) {
        try {
            InitiativeRepaymentReq initiativeRepaymentReq = CjReqUtil.decrypt(requestDto, InitiativeRepaymentReq.class);
            return repaymentService.estimateRepayLP30001(initiativeRepaymentReq);
        } catch (Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP30001】异常", e);
            return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR, "发生异常");
        }
    }

    /**
     * 【LP30001】主动还款相关接口 试算
     * @RequestBody InitiativeRepaymentSubmitReq repaymentSubmitReq
     * @param requestDto
     * @return
     * @author sch
     */
    @RequestMapping("loan/LP30002")
    public ReqToHaierResultDto estimateRepayLP30002(@RequestBody CJRequestDto requestDto) {
        try {
            InitiativeRepaymentSubmitReq initiativeRepaymentSubmitReq = CjReqUtil.decrypt(requestDto, InitiativeRepaymentSubmitReq.class);

            return repaymentService.submitRepayLP30002(initiativeRepaymentSubmitReq);
        } catch (Exception e) {
			MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP30002】异常", e);
            return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR, "发生异常");
        }
    }

    /**
     * 【LP30003】主动还款相关接口 试算
     * @RequestBody InitiativeRepaymentQueryReq repaymentQueryReq
     * @param requestDto
     * @return
     * @author sch
     */
    @RequestMapping("loan/LP30003")
    public ReqToHaierResultDto submitRepayLP30003(@RequestBody CJRequestDto requestDto) {
        try {
            InitiativeRepaymentQueryReq queryReq = CjReqUtil.decrypt(requestDto, InitiativeRepaymentQueryReq.class);
            return repaymentService.submitRepayLP30003(queryReq);
        } catch (Exception e) {
        	MarvelsLogUtil.getInstance().error(requestDto.getRequestNo()+"【LP30003】异常", e);
            return new ReqToHaierResultDto(ReturnCode.SYSTEM_ERROR, "发生异常");
        }
    }

}
