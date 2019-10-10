package com.marvels.test.xyqb;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.fastjson.JSON;
import com.marvels.common.util.FileUploadUtil;
import com.marvels.common.util.hexj.dto.CallbackRepaymentRequest;
import com.marvels.common.util.hexj.dto.CallbackRepaymentRequestBody;
import com.marvels.common.util.hexj.dto.CallbackRequestHead;

public class LP30004RequestTest {
	
	@Test
	public void testParserRequest() throws Exception {
		File file = new ClassPathResource("LP30004-callback.txt").getFile();
		String result = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		CallbackRepaymentRequest request = JSON.parseObject(result, CallbackRepaymentRequest.class);
		CallbackRequestHead head = request.getHead();
		Assert.assertEquals("190618141703000000", head.getSerno());
		
		CallbackRepaymentRequestBody body = request.getBody();
		Assert.assertEquals("HCF-G19002202303223774196001", body.getLoanNo());
	}

}
