package com.marvels.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvels.dto.sy.SyRequestDto;
import com.marvels.dto.sy.SyResponseDto;

/**
 * 对接盛银资金方
 * @author Administrator
 *
 */
@RestController
@RequestMapping
public class ShengYinController {
	
	/**
	 * 获取申请编号
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/sy/ITF00012")
	public SyResponseDto ITF00012(SyRequestDto request) throws Exception {
		return new SyResponseDto();
	}
	
	/**
	 * 贷款申请提交
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/sy/SY00601")
	public SyResponseDto SY00601(SyRequestDto request) throws Exception {
		return new SyResponseDto();
	}
	
	/**
	 * 贷款审批查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/sy/ITF000031")
	public SyResponseDto ITF000031(SyRequestDto request) throws Exception {
		return new SyResponseDto();
	}
	
	/**
	 * 贷款发放查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/sy/ITF000032")
	public SyResponseDto ITF000032(SyRequestDto request) throws Exception {
		return new SyResponseDto();
	}
	
	/**
	 * 还款计划查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/sy/ITF00004")
	public SyResponseDto ITF00004(SyRequestDto request) throws Exception {
		return new SyResponseDto();
	}
	
	/**
	 * 影像信息维护（增、改）
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/sy/ITF00002")
	public SyResponseDto ITF00002(SyRequestDto request) throws Exception {
		return new SyResponseDto();
	}
	
	/**
	 * 放款申请
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/sy/ITF00007")
	public SyResponseDto ITF00007(SyRequestDto request) throws Exception {
		return new SyResponseDto();
	}
	
	/**
	 * CA认证盖章
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/sy/ITF00014")
	public SyResponseDto ITF00014(SyRequestDto request) throws Exception {
		return new SyResponseDto();
	}
	
	/**
	 * 日终文件上传
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/sy/ITF00098")
	public SyResponseDto ITF00098(SyRequestDto request) throws Exception {
		return new SyResponseDto();
	}
	
	/**
	 * 日终文件下载
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/sy/ITF00099")
	public SyResponseDto ITF00099(SyRequestDto request) throws Exception {
		return new SyResponseDto();
	}
	
	/**
	 * 提前结清金额查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/sy/ITF00008")
	public SyResponseDto ITF00008(SyRequestDto request) throws Exception {
		return new SyResponseDto();
	}
	
	/**
	 * 提前结清金额实时提交
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/sy/SY00209")
	public SyResponseDto SY00209(SyRequestDto request) throws Exception {
		return new SyResponseDto();
	}
}
