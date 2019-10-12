package com.marvels.controller;

import com.marvels.dto.jf.*;
import com.marvels.service.JfApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对接玖富资金方-支付业务接口
 * @author Administrator
 *
 */
@RestController
@RequestMapping
public class JiuFuPayController extends BaseController{
	@Autowired
    private JfApiService jfApiService;

	/**
	 * 支持的银行卡列表查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/jf/ITF00012")
	public JfResponseDto queryBankList(@RequestBody JfRequestDto<JfQueryBankListReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
	    return jfApiService.queryBankList(request);
	}
	
	/**
	 * 卡bin查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/jf/ITF00012")
	public JfResponseDto queryCardBin(@RequestBody JfRequestDto<JfQueryCardBinReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
	    return jfApiService.queryCardBin(request);
	}
	
	/**
	 * 鉴权查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/jf/ITF00012")
	public JfResponseDto queryAuthCard(@RequestBody JfRequestDto<JfQueryAuthCardReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
	    return jfApiService.queryAuthCard(request);
	}
	
	/**
	 * 签约申请
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/jf/ITF00012")
	public JfResponseDto signApply(@RequestBody JfRequestDto<JfSignApplyReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
	    return jfApiService.signApply(request);
	}
	
	/**
	 * 签约确认
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("credit/jf/ITF00012")
	public JfResponseDto confirmSign(@RequestBody JfRequestDto<JfConfirmSignReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
	    return jfApiService.confirmSign(request);
	}
}
