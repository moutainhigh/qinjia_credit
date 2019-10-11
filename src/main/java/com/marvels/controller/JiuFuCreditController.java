package com.marvels.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;

/**
 * 对接玖富资金方
 * @author Administrator
 *
 */
@RestController
@RequestMapping
public class JiuFuCreditController {
	
	/**
	 * 获取申请编号
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/jf/ITF00012")
	public JfResponseDto ITF00012(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
}
