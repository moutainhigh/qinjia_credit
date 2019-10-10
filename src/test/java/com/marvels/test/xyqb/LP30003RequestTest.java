package com.marvels.test.xyqb;

import com.alibaba.fastjson.JSON;
import com.marvels.common.enums.XyqbCodeAndUrlEnum;
import com.marvels.common.util.FileUploadUtil;
import com.marvels.common.util.hexj.ReqToHaierUtil;
import com.marvels.dto.hexj.response.ReqToHaierResultDto;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.File;


public class LP30003RequestTest {
	@Autowired
	private PaymentInfoServiceImpl service;

	@Test
	public void testParserRequest() throws Exception {
		File file = new ClassPathResource("LP30003-data.txt").getFile();
		String result = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		InitiativeRepaymentQueryReq request = JSON.parseObject(result, InitiativeRepaymentQueryReq.class);
		Assert.assertEquals("17896389", request.getBody().getList().get(0).getApplSeq());

		ReqToHaierResultDto reqToHaierResultDto = new InitiativeRepaymentServiceIml().submitRepayLP30003(request);
		System.out.println("接口返回:"+JSON.toJSONString(reqToHaierResultDto));


	}
	
	@Test
	public void testSendRequest() throws Exception {
		File file = new ClassPathResource("LP30003-data2.txt").getFile();
		String result = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		InitiativeRepaymentQueryBody request = JSON.parseObject(result, InitiativeRepaymentQueryBody.class);
		ReqToHaierResultDto reqToHaierResultDto = ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP30003.getUrl(), XyqbCodeAndUrlEnum.LP30003.getCode(), request);
		System.out.println(reqToHaierResultDto);
	}

}
