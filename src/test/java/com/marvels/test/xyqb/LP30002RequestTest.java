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


public class LP30002RequestTest {
	@Autowired
	private PaymentInfoServiceImpl service;

	@Test
	public void testParserRequest() throws Exception {
		File file = new ClassPathResource("LP30002-data.txt").getFile();
		String result = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		InitiativeRepaymentSubmitReq request = JSON.parseObject(result, InitiativeRepaymentSubmitReq.class);
		Assert.assertEquals("11111111111111111111", request.getBody().getList().get(0).getAcCardNo());

		ReqToHaierResultDto reqToHaierResultDto = new InitiativeRepaymentServiceIml().submitRepayLP30002(request);
		System.out.println("接口返回:"+JSON.toJSONString(reqToHaierResultDto));
	}
	
	@Test
	public void testSendRequest() throws Exception {
		File file = new ClassPathResource("LP30002-data2.txt").getFile();
		String result = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		InitiativeRepaymentSubmitBody request = JSON.parseObject(result, InitiativeRepaymentSubmitBody.class);
		ReqToHaierResultDto reqToHaierResultDto = ReqToHaierUtil.request(XyqbCodeAndUrlEnum.LP30002.getUrl(), XyqbCodeAndUrlEnum.LP30002.getCode(), request);
		System.out.println(reqToHaierResultDto);
	}

}
