package com.marvels.test.xyqb;

import com.alibaba.fastjson.JSON;
import com.marvels.common.util.FileUploadUtil;
import com.marvels.common.util.MarvelsLogUtil;
import com.marvels.dto.hexj.response.ReqToHaierResultDto;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.File;


public class LP20002RequestTest {
	private static Logger logger = Logger.getLogger(LP20002RequestTest.class);


	@Test
	public void testParserRequest() throws Exception {
		File file = new ClassPathResource("LP20002-data.txt").getFile();
		String result = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		PaymentInfoReq request = JSON.parseObject(result, PaymentInfoReq.class);
		Assert.assertEquals("330501199210262246", request.getPaymentInfoBody().getId_no());

		ReqToHaierResultDto reqToHaierResultDto = new PaymentInfoServiceImpl().paymentInfoLP20002(request);
		MarvelsLogUtil.getInstance().warn("接口返回:"+JSON.toJSONString(reqToHaierResultDto));

	}

}
