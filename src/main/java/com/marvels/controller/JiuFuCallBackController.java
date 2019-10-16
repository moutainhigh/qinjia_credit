package com.marvels.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 玖富资金方回调接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping
public class JiuFuCallBackController {
	
	/**
	 * 扣款结果回调
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("qjcs/callback/jf/repayResult")
	public Object repayResult() throws Exception {
		return null;
	}
	
	/**
	 * 授信结果回调
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("qjcs/callback/jf/applyResult")
	public Object applyResult() throws Exception {
		return null;
	}
	
	/**
	 * 关单结果回调
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("qjcs/callback/jf/closeOrderResult")
	public Object closeOrderResult() throws Exception {
		return null;
	}
	
	/**
	 * 放款结果回调
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("qjcs/callback/jf/loanResult")
	public Object loanResult() throws Exception {
		return null;
	}
}
