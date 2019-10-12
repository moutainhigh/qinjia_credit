package com.marvels.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;

/**
 * 对接玖富资金方-还款业务接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping
public class JiuFuRepaymentController {
	
	/**
	 * 借据编号查询借据信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("ioucenter/iou/getIou")
	public JfResponseDto getIou(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
	
	/**
	 * 查询用户所有的借据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("ioucenter/iou/getIouByCustNo")
	public JfResponseDto getIouByCustNo(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
	
	/**
	 * 还款计划查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("ioucenter/iou/getRepayPlan")
	public JfResponseDto getRepayPlan(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
	
	/**
	 * 还款金额试算
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("ioucenter/iou/queryRepayAmt")
	public JfResponseDto queryRepayAmt(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
	
	/**
	 * 主动还款
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("ioucent/repay/repay")
	public JfResponseDto repay(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
	
	/**
	 * 扣款结果查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("ioucent/repay/queryRepayResult")
	public JfResponseDto queryRepayResult(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
	
	/**
	 * 查询用户还款记录
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("ioucent/repay/queryRepayRecord")
	public JfResponseDto queryRepayRecord(JfRequestDto request) throws Exception {
		return new JfResponseDto();
	}
}
