package com.marvels.test.xyqb;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.marvels.common.enums.XyqbCodeAndUrlEnum;
import com.marvels.common.util.hexj.ReqToHaierUtil;
import com.marvels.dto.hexj.response.ReqToHaierResultDto;

public class XyqbTest {
	
	private static Logger logger = Logger.getLogger(XyqbTest.class);


	public static ReqToHaierResultDto 额度申请信息保存LP10008(){
		CriditApplyDto criditApplyDto = TestUtil.parseTestDate("LP10008-ACQ-4001.json", CriditApplyDto.class);
		ReqToHaierResultDto  reqToHaierResultDto =  ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP10008.getUrl(), XyqbCodeAndUrlEnum.LP10008.getCode(), criditApplyDto);
		logger.info("[额度申请信息保存LP10008],海尔消金返回="+JSON.toJSONString(reqToHaierResultDto));
		return reqToHaierResultDto;
	}
	
	public static ReqToHaierResultDto 额度申请提交LP10009(){
		CriditApplyDto criditApplyDto = TestUtil.parseTestDate("LP10009-ACQ-4002.json", CriditApplyDto.class);
		ReqToHaierResultDto  reqToHaierResultDto =  ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP10009.getUrl(), XyqbCodeAndUrlEnum.LP10009.getCode(), criditApplyDto);
		logger.info("[额度申请信息提交LP10008],海尔消金返回="+JSON.toJSONString(reqToHaierResultDto));
		return reqToHaierResultDto;
	}
	
	public static ReqToHaierResultDto 额度申请进度查询LP10010(){
		CriditApplyDto criditApplyDto = TestUtil.parseTestDate("LP10010-ACQ-4003.json", CriditApplyDto.class);
		ReqToHaierResultDto  reqToHaierResultDto =  ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP10010.getUrl(), XyqbCodeAndUrlEnum.LP10010.getCode(), criditApplyDto);
		logger.info("[额度申请信息进度查询LP10010],海尔消金返回="+JSON.toJSONString(reqToHaierResultDto));
		return reqToHaierResultDto;
	}
	
	public static ReqToHaierResultDto 现金贷支用信息保存LP20002(){
		CriditApplyDto criditApplyDto = TestUtil.parseTestDate("LP20002.json", CriditApplyDto.class);
		ReqToHaierResultDto  reqToHaierResultDto =  ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP20002.getUrl(), XyqbCodeAndUrlEnum.LP20002.getCode(), criditApplyDto);
		logger.info("[额度申请信息进度查询LP10010],海尔消金返回="+JSON.toJSONString(reqToHaierResultDto));
		return reqToHaierResultDto;
	}
	
	public static void main(String[] args) {
		//额度申请信息保存LP10008();
		//额度申请提交LP10009();
		额度申请进度查询LP10010();
		//现金贷支用信息保存LP20002();
//		CriditApplyDto criditApplyDto = TestUtil.parseTestDate("LP10008-ACQ-4001.json", CriditApplyDto.class);
//		CJRequestDto dto = CJToYkgUtil.encryptAndSign(criditApplyDto);
//		dto.setRequestNo("8980erqwerqwerwe");
//		logger.info("待发给云科谷的报文"+JSON.toJSONString(dto));
		
	}
}
