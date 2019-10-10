/*
 * 功  能：简单说明该类的功能
 *
 * 文件名：OrangeImageVO.java
 *
 * 描  述：
 *
 * [变更履历]
 * Version   变更日         部署              作者           变更内容
 * -----------------------------------------------------------------------------
 * V1.00     2015年8月18日   haiercash    xuchao      CREATE
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

/**
 *  DESCRIPTION:
 *
 * <p>
 * <a href="OrangeImageVO.java"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:xuchao@haiercash.com">xuchao</a>
 *
 * @version Revision: 1.0  Date: 2015年8月18日 下午9:23:36
 *
 */

public class ImageUploadVO implements Serializable{
	private String filename;
	private String fileoper;
	private String fileType;
	private String file;
	private String md5;
	
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileoper() {
		return fileoper;
	}
	public void setFileoper(String fileoper) {
		this.fileoper = fileoper;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
}
