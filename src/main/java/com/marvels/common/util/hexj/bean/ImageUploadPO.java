/*
 * 功  能：简单说明该类的功能
 *
 * 文件名：ChinaTelecomLoanApplicationBean.java
 *
 * 描  述：
 *
 * [变更履历]
 * Version   变更日         部署              作者           变更内容
 * -----------------------------------------------------------------------------
 * V1.00     2015年6月12日   haiercash    xuchao      CREATE
 * -----------------------------------------------------------------------------
 *
 *
 * Copyright (c) 2015 haiercash All Rights Reserved.
 *┌─────────────────────────────────────────────────—────┐
 *│ 版权声明                               haiercash       │
 *└──────────────────────────────—————————————————————───┘
 */

package com.marvels.common.util.hexj.bean;


import java.io.Serializable;
import java.util.List;

/**
 * 
 *  DESCRIPTION:附件上传pojo
 * <p>
 * <a href="OrangeLoanApplicationBean.java"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:xuchao@haiercash.com">xuchao</a>
 *
 * @version Revision: 1.0  Date: 2015年8月11日 上午11:09:33
 *
 */

public class ImageUploadPO implements Serializable{
	private String channelNo;//渠道编码
	private String appno ;//流水号
	private String apptime ;//申请时间
	private String appl ;//申请编号
	private List<ImageUploadVO> filelist ;//

	public String getAppno() {
		return appno;
	}
	public void setAppno(String appno) {
		this.appno = appno;
	}
	public String getApptime() {
		return apptime;
	}
	public void setApptime(String apptime) {
		this.apptime = apptime;
	}
	public String getAppl() {
		return appl;
	}
	public void setAppl(String appl) {
		this.appl = appl;
	}
	
	public List<ImageUploadVO> getFilelist() {
		return filelist;
	}
	public void setFilelist(List<ImageUploadVO> filelist) {
		this.filelist = filelist;
	}
	public String getChannelNo() {
		return channelNo;
	}

	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}

	
}
