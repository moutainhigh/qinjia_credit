package com.marvels.test.xyqb;

import com.alibaba.fastjson.JSON;
import com.marvels.common.enums.XyqbCodeAndUrlEnum;
import com.marvels.common.util.FileUploadUtil;
import com.marvels.common.util.hexj.ReqToHaierUtil;
import com.marvels.dto.hexj.response.ReqToHaierResultDto;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;


public class LP30001RequestTest {
	private static Logger logger = Logger.getLogger(LP30001RequestTest.class);

	@Test
	public void testParserRequest() throws Exception {
		File file = new ClassPathResource("LP30001-data.txt").getFile();
		String result = FileUploadUtil.getFileStreamAsString(file, "UTF-8");

		InitiativeRepaymentReq request = JSON.parseObject(result, InitiativeRepaymentReq.class);
		Assert.assertEquals("HCF-YKG30201812294910445001", request.getLoanNo());

		ReqToHaierResultDto reqToHaierResultDto = new InitiativeRepaymentServiceIml().estimateRepayLP30001(request);

		System.out.println("接口返回:"+JSON.toJSONString(reqToHaierResultDto));
		logger.warn("接口返回:"+JSON.toJSONString(reqToHaierResultDto));

	}
	
	@Test
	public void testSendRequest() throws Exception {
		File file = new ClassPathResource("LP30001-data2.txt").getFile();
		String result = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		InitiativeRepaymentReq request = JSON.parseObject(result, InitiativeRepaymentReq.class);
		ReqToHaierResultDto reqToHaierResultDto = ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP30001.getUrl(), XyqbCodeAndUrlEnum.LP30001.getCode(), request);
		System.out.println(reqToHaierResultDto);
	}

}
