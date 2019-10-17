package com.marvels.controller;

import com.marvels.dto.jf.*;
import com.marvels.service.JfApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对接玖富资金方-还款业务接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping("qjcs/api/jf/")
public class JiuFuRepaymentController extends BaseController{

    @Autowired
    private JfApiService jfApiService;
	/**
	 * 借据编号查询借据信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100174")
	public JfResponseDto getIou(JfRequestDto<JfGetIouReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.getIou(request);
	}

	/**
	 * 还款计划查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100175")
	public JfResponseDto getRepayPlan(JfRequestDto<JfGetIouReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.getRepayPlan(request);
	}
	
	/**
	 * 还款金额试算
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100176")
	public JfResponseDto queryRepayAmt(JfRequestDto<JfQueryRepayAmtReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.queryRepayAmt(request);
	}
	
	/**
	 * 主动还款
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100177")
	public JfResponseDto repay(JfRequestDto<JfRayReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.repay(request);
	}
	
	/**
	 * 扣款结果查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100178")
	public JfResponseDto queryRepayResult(JfRequestDto<JfQueryRepayResultReq>  request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.queryRepayResult(request);
	}
	
	/**
	 * 查询用户还款记录
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100179")
	public JfResponseDto queryRepayRecord(JfRequestDto<JfQueryRepayRecourdReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.queryRepayRecord(request);
	}
}
