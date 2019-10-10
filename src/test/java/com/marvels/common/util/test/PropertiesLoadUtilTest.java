package com.marvels.common.util.test;

import org.junit.Assert;
import org.junit.Test;

import com.marvels.common.util.PropertiesLoadUtil;

/**
 * 
 * @author jason
 *
 */
public class PropertiesLoadUtilTest {
	
	@Test
	public void testGetProperty() {
		String channelno = PropertiesLoadUtil.getPropertiesValue("xyqb.haier.channelno", "forms-openapi.properties");
		Assert.assertEquals("E8", channelno);
	}

}
