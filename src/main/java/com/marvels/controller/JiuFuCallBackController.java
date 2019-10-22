package com.marvels.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 玖富资金方回调接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping("qjcs/callback/jf/")
public class JiuFuCallBackController {
	
	/**
	 * 扣款结果回调
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("repayResult")
	public Object repayResult() throws Exception {
		return null;
	}
	
	/**
	 * 授信结果回调
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("applyResult")
	public Object applyResult() throws Exception {
		return null;
	}
	
	/**
	 * 关单结果回调
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("closeOrderResult")
	public Object closeOrderResult() throws Exception {
		return null;
	}
	
	/**
	 * 放款结果回调
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("loanResult")
	public Object loanResult() throws Exception {
		return null;
	}
}
