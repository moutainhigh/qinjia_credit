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


public class LP30015Test {
	
	@Test
	public void testParseRequestBody() throws Exception {
		File file = new ClassPathResource("LP30015-data.txt").getFile();
		String json = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		BatchChangeAcctReqBody body = JSON.parseObject(json, BatchChangeAcctReqBody.class);
		Assert.assertEquals(1, body.getAcctInfoList().size());
		BatchChangeAcctReqBodytList result = body.getAcctInfoList().get(0);
		Assert.assertEquals("HCF-DFCF02201903296096164001",result.getLoanNo());
		Assert.assertEquals("1111111111111111111", result.getAcctNo());
		Assert.assertEquals("xxx", result.getActName());
		Assert.assertEquals("105", result.getAccBankCde());
		Assert.assertEquals("110000", result.getNewBankProvince());
		Assert.assertEquals("110100", result.getNewBankCity());
		Assert.assertEquals("414801", result.getUsrCde());
		Assert.assertEquals("建设银行", result.getAcctBchDescc());
		Assert.assertEquals("105", result.getAcctBchCde());
	}
	
	@Test
	public void testParseResponseBody() throws Exception {
		File file = new ClassPathResource("LP30015-response.txt").getFile();
		String json = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		BatchChangeAcctRespBody body = JSON.parseObject(json,BatchChangeAcctRespBody.class);
		Assert.assertEquals(1, body.getResultList().size());
		BatchChangeAcctRespBodyResultList result = body.getResultList().get(0);
		Assert.assertEquals("jason",result.getUserId());
		Assert.assertEquals("456", result.getAcctChgSeq());
		Assert.assertEquals("123", result.getLoanNo());
	}

	@Test
	public void testSendRequest() throws Exception {
		System.setProperty("javax.net.ssl.trustStore", "C:\\work\\workspace\\phoneplat-job\\jssecacerts");
		File file = new ClassPathResource("LP30015-data.txt").getFile();
		String json = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		BatchChangeAcctReqBody body = JSON.parseObject(json, BatchChangeAcctReqBody.class);
		HexjApi api = new HexjApiImpl();
		ReqToHaierResultDto dto = api.batchChangeAcct(body);
		System.out.println(dto);
		String respBodyString = dto.getBody();
		System.out.println(respBodyString);
		if ("00000".equals(dto.getReturnCode())) {
			BatchChangeAcctRespBody respBody = JSON.parseObject(respBodyString, BatchChangeAcctRespBody.class);
			System.out.println(respBody.getResultList().size());
		} else {
			System.out.println(dto.getReturnMsg());
		}
		
	}
	
	@Test
	public void testSendRequest2() throws Exception {
		File file = new ClassPathResource("LP30015-data2.txt").getFile();
		String json = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		BatchChangeAcctReqBody body = JSON.parseObject(json, BatchChangeAcctReqBody.class);
		HexjApi api = new HexjApiImpl();
		ReqToHaierResultDto dto = api.batchChangeAcct(body);
		System.out.println(dto);
		String respBodyString = dto.getBody();
		System.out.println(respBodyString);
		if ("00000".equals(dto.getReturnCode())) {
			BatchChangeAcctRespBody respBody = JSON.parseObject(respBodyString, BatchChangeAcctRespBody.class);
			System.out.println(respBody.getResultList().size());
		} else {
			System.out.println(dto.getReturnMsg());
		}
		
	}
	
}
