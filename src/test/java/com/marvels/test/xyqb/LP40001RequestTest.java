package com.marvels.test.xyqb;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.fastjson.JSON;
import com.marvels.common.util.FileUploadUtil;
import com.marvels.dto.hexj.response.ReqToHaierResultDto;
import com.marvels.external.HexjApi;
import com.marvels.external.impl.HexjApiImpl;


public class LP40001RequestTest {
	
	@Test
	public void testParserRequest() throws Exception {
		File file = new ClassPathResource("LP40001-data.txt").getFile();
		String result = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		RiskInfoUploadReq request = JSON.parseObject(result, RiskInfoUploadReq.class);
		Assert.assertEquals("12345678", request.getApplseq());
		
		RiskInfoUploadReqData data = request.getData();
		Assert.assertEquals("114.111111111111,30.1111111111111", data.getNappGlobalPS());
		Assert.assertEquals("2015-03-01", data.getIdcard_validity_startdate());
		
	}
	
	@Test
	public void testSendRequest() throws Exception {
		File file = new ClassPathResource("LP40001-data.txt").getFile();
		String result = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		RiskInfoUploadReq request = JSON.parseObject(result, RiskInfoUploadReq.class);
		//System.setProperty("javax.net.ssl.trustStore", "C:\\work\\workspace\\phoneplat-job\\jssecacerts");
		HexjApi api = new HexjApiImpl();
		ReqToHaierResultDto dto = api.riskInfoUpload(request);
		//接口返回：{"head":{"retFlag":"00000","retMsg":"处理成功"}}&&KotjuxHLBM7jD0/JgrLb8WxrXOHhacASThCS7j7S4Je8t8MjbmoIDoKiB5UJowBJ6BMkpEhGhOnCUPl3HXd0Zw==
		Assert.assertEquals("00000", dto.getReturnCode());
	}

}
