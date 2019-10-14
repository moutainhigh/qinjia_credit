package com.marvels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvels.dto.jf.JfApplyQuotaReq;
import com.marvels.dto.jf.JfQueryApplyResultReq;
import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;
import com.marvels.service.JfApiService;

/**
 * 对接玖富资金方-授信业务接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping
public class JiuFuCreditController extends BaseController{
	
	/**
	 * 玖富对接服务
	 */
	@Autowired
	private JfApiService jfApiService;
	
	/**
	 *授信请求
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/center/applyQuota/v2")
	public JfResponseDto applyQuota(JfRequestDto<JfApplyQuotaReq> request) throws Exception {
		JfResponseDto result = super.checkBuildSysCode(request);
		if (null != result)  {
			return result;
		}
		return jfApiService.applyQuota(request);
	}
	
	/**
	 *授信结果查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/center/query/result/v2")
	public JfResponseDto queryApplyResult(JfRequestDto<JfQueryApplyResultReq> request) throws Exception {
		JfResponseDto result = super.checkBuildSysCode(request);
		if (null != result)  {
			return result;
		}
		return jfApiService.queryApplyResult(request);
	}
}
