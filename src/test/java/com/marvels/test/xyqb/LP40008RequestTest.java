package com.marvels.test.xyqb;

import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.fastjson.JSON;
import com.marvels.common.util.FileUploadUtil;
import com.marvels.common.util.hexj.dto.CallbackRequest;
import com.marvels.common.util.hexj.dto.CallbackRequestBody;
import com.marvels.common.util.hexj.dto.CallbackRequestBodyProduct;
import com.marvels.common.util.hexj.dto.CallbackRequestBodyProductRate;
import com.marvels.common.util.hexj.dto.CallbackRequestHead;

public class LP40008RequestTest {
	@Test
	public void testParserRequest() throws Exception {
		File file = new ClassPathResource("LP40008-callback.txt").getFile();
		String result = FileUploadUtil.getFileStreamAsString(file, "UTF-8");
		
		CallbackRequest request = JSON.parseObject(result, CallbackRequest.class);
		CallbackRequestHead head = request.getHead();
		Assert.assertEquals("606051390850072576", head.getSerno());
		
		CallbackRequestBody body = request.getBody();
		Assert.assertEquals("13455915", body.getApplSeq());
		
		List<CallbackRequestBodyProduct> productList = body.getProductInfo();
		Assert.assertEquals(8, productList.size());
		
		CallbackRequestBodyProduct product1 = productList.get(0);
		Assert.assertEquals("15070a", product1.getTypCde());
		
		CallbackRequestBodyProduct product2 = productList.get(1);
		List<CallbackRequestBodyProductRate> rateList = product2.getIntRatList();
		Assert.assertEquals(2, rateList.size());
		CallbackRequestBodyProductRate rate1 = rateList.get(0);
		Assert.assertEquals("0.00000", rate1.getIntRatMonth());



	}
}
