package com.marvels.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;

/**
 * 对接玖富资金方-授信业务接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping
public class JiuFuCreditController {
	
	/**
	 *授信请求
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/center/applyQuota/v2")
	public JfResponseDto applyQuota(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
	
	/**
	 *授信结果查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/center/query/result/v2")
	public JfResponseDto queryApplyResult(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
}
