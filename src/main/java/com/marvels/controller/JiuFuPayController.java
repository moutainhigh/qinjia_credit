package com.marvels.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;

/**
 * 对接玖富资金方-支付业务接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping
public class JiuFuPayController {
	
	/**
	 * 支持的银行卡列表查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/jf/ITF00012")
	public JfResponseDto queryBankList(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
	
	/**
	 * 卡bin查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/jf/ITF00012")
	public JfResponseDto queryCardBin(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
	
	/**
	 * 鉴权查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/jf/ITF00012")
	public JfResponseDto queryAuthCard(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
	
	/**
	 * 签约申请
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/jf/ITF00012")
	public JfResponseDto signApply(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
	
	/**
	 * 签约确认
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/jf/ITF00012")
	public JfResponseDto confirmSign(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
}
