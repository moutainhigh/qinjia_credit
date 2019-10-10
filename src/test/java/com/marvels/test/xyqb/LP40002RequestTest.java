package com.marvels.test.xyqb;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.fastjson.JSON;
import com.marvels.common.util.FileUploadUtil;
import com.marvels.dto.hexj.response.ReqToHaierResultDto;
import com.marvels.external.HexjApi;
import com.marvels.external.impl.HexjApiImpl;

public class LP40002RequestTest {
	
	@Test
	public void testParserRequest() throws Exception {
		File file = new ClassPathResource("LP40002-data.txt").getFile();
		String result = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		
		FileUploadReq request = JSON.parseObject(result, FileUploadReq.class);
		Assert.assertEquals("HAIERCF-20190618152225-000000", request.getAppno());
		List<FileUploadReqFile> fileList = request.getFilelist();
		Assert.assertEquals(1, fileList.size());
		FileUploadReqFile attachFile = fileList.get(0);
		Assert.assertEquals("个人借款合同.pdf", attachFile.getFilename());
	}
	
	@Test
	public void testSendRequest() throws Exception {
		File file = new ClassPathResource("LP40002-data.txt").getFile();
		String result = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		FileUploadReq request = JSON.parseObject(result, FileUploadReq.class);
		String[] fileStream = FileUploadUtil.getUploadFileStream(new File("C:\\Users\\jason\\Desktop\\1.png"));
		request.getFilelist().get(0).setFile(fileStream[0]);
		request.getFilelist().get(0).setMd5(fileStream[1]);
		System.out.println("md5="+fileStream[1]);
		String appno = UUID.randomUUID().toString().replace("-", "");
		request.setAppno(appno);
		System.out.println("appno="+appno);
		System.setProperty("javax.net.ssl.trustStore", "C:\\work\\workspace\\phoneplat-job\\jssecacerts");
		HexjApi api = new HexjApiImpl();
		ReqToHaierResultDto dto = api.fileUpload(request);
		System.out.println(dto);
		Assert.assertEquals("00000", dto.getReturnCode());
	}
	
}
