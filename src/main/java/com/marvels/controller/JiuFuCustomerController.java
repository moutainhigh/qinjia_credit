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
@RequestMapping
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
	@RequestMapping("cif/ocr/upload")
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
	@RequestMapping("cif/customerFace/faceRecogSave/v1")
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
	@RequestMapping("cif/CustomerKyc/saveCustomerKyc/v1")
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
	@RequestMapping("cif/CustomerBaseInfo2Out/getCustomerBaseInfo/v1")
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
	@RequestMapping("cif/CustomerBaseInfo2Out/getCustomerBaseInfoByIdNo/v1")
	public JfResponseDto saveCreditGranting(@RequestBody JfRequestDto<Jf100173Req> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.getCustomerBaseInfoByIdNo(request);
	}
	
	/**
	 * 风控设备指纹实时反欺诈
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("cif/bankCard/authorize/v1")
	public JfResponseDto fgpAntiFraud(@RequestBody JfRequestDto<Jf100183Req> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.authBankCard(request);
	}
	
	/**
	 * 运营商授权
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("cif/operator/authorize/v1")
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
	@RequestMapping("cif/creditCard/authorize/v1")
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
	@RequestMapping("cif/bankCard/query/v1")
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
	@RequestMapping("cif/authorize/status/v1")
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
	@RequestMapping("cif/authorize/callback/v1")
	public JfResponseDto callBackAuth(@RequestBody JfRequestDto<JfCallBackAuthReq> request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.callBackAuth(request);
	}

}
