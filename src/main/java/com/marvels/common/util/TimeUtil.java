/*
 * 功  能：简单说明该类的功能
 * 
 * 文件名：TimeUtil.java
 * 
 * 描  述：
 * 
 * [变更履历]
 * Version   变更日         部署              作者           变更内容
 * -----------------------------------------------------------------------------
 * V1.00     2015年12月28日   Haiercash    suyang      CREATE
 * -----------------------------------------------------------------------------
 *
 *
 * Copyright (c) 2015 Haiercash All Rights Reserved.
 *┌─────────────────────────────────────────────────—────┐
 *│ 版权声明                               Haiercash       │
 *└──────────────────────────────—————————————————————───┘
 */

package com.marvels.common.util;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  DESCRIPTION:
 *
 * <p>
 * <a href="TimeUtil.java"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:suyang@haiercash.com">suyang</a>
 *
 * @version Revision: 1.0  Date: 2015年12月28日 上午11:07:16 
 *
 */

public class TimeUtil {
	
	
   /**
    *@Title:getPreciseTime
    *@Description:
    *@author  'zyj'
    *@date 2016年6月23日 上午11:41:19
    *@return
    */
   public static String getPreciseTime(){
		SimpleDateFormat  df  =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return df.format(new Date());
   }
   
   
   
	
}
