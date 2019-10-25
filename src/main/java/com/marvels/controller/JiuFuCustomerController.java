package com.marvels.controller;

import com.marvels.dto.jf.customer.*;
import com.marvels.dto.jf.JfRequestDto;
import com.marvels.dto.jf.JfResponseDto;
import com.marvels.service.JfApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对接玖富-客戶中心业务
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/qjcs/api/jf")
public class JiuFuCustomerController extends BaseController {

    /**
     * 玖富对接服务
     */
    @Autowired
    private JfApiService jfApiService;
	
	/**
	 * 实名认证
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100163")
	public JfResponseDto authName(@RequestBody JfRequestDto<JfAuthNameReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.authName(request);
	}
	
	/**
	 * 人脸识别结果上传
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100164")
	public JfResponseDto faceRecogSave(@RequestBody JfRequestDto<JfFaceRecogSaveReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.faceRecogSave(request);
	}
	
	/**
	 * KYC信息提交
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100165")
	public JfResponseDto saveCustomerKyc(@RequestBody JfRequestDto<JfCustomerKycReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.saveCustomerKyc(request);
	}
	
	/**
	 * 借记卡授权
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100166")
	public JfResponseDto grantDebitCard(@RequestBody JfRequestDto<Jf100166Req> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.getCustomerBaseInfo(request);
	}
	
	/**
	 * 商户授信结果信息接收
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100173")
	public JfResponseDto saveCreditGranting(@RequestBody JfRequestDto<Jf100173Req> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.saveCreditGranting(request);
	}
	
	/**
	 * 风控设备指纹实时反欺诈
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100183")
	public JfResponseDto fgpAntiFraud(@RequestBody JfRequestDto<Jf100183Req> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.fgpAntiFraud(request);
	}
	
	/**
	 * 运营商授权
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100167")
	public JfResponseDto authOperator(@RequestBody JfRequestDto<JfAuthOperatorReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.authOperator(request);
	}
	
	/**
	 * 信用卡授权
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100168")
	public JfResponseDto authCreditCard(@RequestBody JfRequestDto<JfAuthorizeReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.authCreditCard(request);
	}
	
	/**
	 * 额度查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100184")
	public JfResponseDto queryBankCard(@RequestBody JfRequestDto<Jf100184Req> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.queryBankCard(request);
	}
	
	/**
	 * 授信项状态查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100169")
	public JfResponseDto queryCreditStatus(@RequestBody JfRequestDto<JfCreditStatusReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.queryCreditStatus(request);
	}
	
	/**
	 * 商户接收授权结果
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100170")
	public JfResponseDto callBackAuth(@RequestBody JfRequestDto<JfCallBackAuthReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.callBackAuth(request);
	}


	/**
	 * 用于查询用户已绑定的银行卡列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100185")
	public JfResponseDto queryBindCard(@RequestBody JfRequestDto<Jf100185Req> request) throws Exception {
		JfResponseDto result = super.checkBuildSysCode(request);
		if (null != result)  {
			return result;
		}
		return jfApiService.queryBindCard(request);
	}

	/**
	 * 根据身份证号码查询客户基本信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100186")
	public JfResponseDto queryUserInfoByCid(@RequestBody JfRequestDto<Jf100186Req> request) throws Exception {
		JfResponseDto result = super.checkBuildSysCode(request);
		if (null != result)  {
			return result;
		}
		return jfApiService.queryUserInfoByCid(request);
	}


	/**
	 * 客户注册接口 (实名 )
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("100187")
	public JfResponseDto register(@RequestBody JfRequestDto<Jf100187Req> request) throws Exception {
		JfResponseDto result = super.checkBuildSysCode(request);
		if (null != result)  {
			return result;
		}
		return jfApiService.register(request);
	}
}
