package com.marvels.controller;

import com.marvels.common.enums.PublicEnums;
import com.marvels.dto.jf.JfAuthNameReq;
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
	public JfResponseDto faceRecogSave(@RequestBody JfRequestDto request) throws Exception {
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
	public JfResponseDto saveCustomerKyc(@RequestBody JfRequestDto request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.saveCustomerKyc(request);
	}
	
	/**
	 * 客户基本信息查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("cif/CustomerBaseInfo2Out/getCustomerBaseInfo/v1")
	public JfResponseDto getCustomerBaseInfo(@RequestBody JfRequestDto request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.getCustomerBaseInfo(request);
	}
	
	/**
	 * 用于个人信息查询-基于身份证号码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("cif/CustomerBaseInfo2Out/getCustomerBaseInfoByIdNo/v1")
	public JfResponseDto getCustomerBaseInfoByIdNo(@RequestBody JfRequestDto request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.getCustomerBaseInfoByIdNo(request);
	}
	
	/**
	 * 银行卡鉴权
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("cif/bankCard/authorize/v1")
	public JfResponseDto authBankCard(@RequestBody JfRequestDto request) throws Exception {
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
	public JfResponseDto authOperator(@RequestBody JfRequestDto request) throws Exception {
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
	public JfResponseDto authCreditCard(@RequestBody JfRequestDto request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.authCreditCard(request);
	}
	
	/**
	 * 绑卡列表查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("cif/bankCard/query/v1")
	public JfResponseDto queryBankCard(@RequestBody JfRequestDto request) throws Exception {
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
	public JfResponseDto queryCreditStatus(@RequestBody JfRequestDto request) throws Exception {
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
	public JfResponseDto callBackAuth(@RequestBody JfRequestDto request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.callBackAuth(request);
	}
	
	/**
	 * 交易绑卡落库
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("cif/tradingCard/changeCardSave/v1")
	public JfResponseDto changeCard(@RequestBody JfRequestDto request) throws Exception {
        JfResponseDto result = super.checkBuildSysCode(request);
        if (null != result)  {
            return result;
        }
        return jfApiService.changeCard(request);
	}



}
