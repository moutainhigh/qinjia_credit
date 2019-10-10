package com.marvels.test.xyqb;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.fastjson.JSON;
import com.marvels.common.util.FileUploadUtil;
import com.marvels.dto.hexj.response.ReqToHaierResultDto;
import com.marvels.external.HexjApi;
import com.marvels.external.impl.HexjApiImpl;


public class LP30006Test {
	
	@Test
	public void testParseResponseBody() throws Exception {
		File file = new ClassPathResource("LP30006-response.txt").getFile();
		String json = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		RepayPlanQueryRespBody body = JSON.parseObject(json, RepayPlanQueryRespBody.class);
		Assert.assertEquals("baafc27776e74f16b595b80948156d8e", body.getSerno());
		
		List<RepayPlanQueryRespBodyResultList> resultList = body.getResultList();
		Assert.assertEquals(1, resultList.size());
		
		RepayPlanQueryRespBodyResultList result = resultList.get(0);
		Assert.assertEquals("512019002743", result.getSuperCoopr());

		List<RepayPlanQueryRespBodyImPmShdList> list = result.getLmPmShdList();
		Assert.assertEquals(7, list.size());
		
		RepayPlanQueryRespBodyImPmShdList shd = list.get(0);
		Assert.assertEquals(new BigDecimal("748.5"), shd.getPsRemPrcp());
	}
	
	@Test
	public void testSendRequest() throws Exception {
		System.setProperty("javax.net.ssl.trustStore", "C:\\work\\workspace\\phoneplat-job\\jssecacerts");
		RepayPlanQueryReqBody body = new RepayPlanQueryReqBody("11111111111",null);
		HexjApi api = new HexjApiImpl();
		ReqToHaierResultDto dto = api.repayPlanQuery(body);
		System.out.println(dto);
		String responseBodyString = dto.getBody();
		RepayPlanQueryRespBody respBody = JSON.parseObject(responseBodyString, RepayPlanQueryRespBody.class);
		System.out.println("serno="+respBody.getSerno());
	}

}
