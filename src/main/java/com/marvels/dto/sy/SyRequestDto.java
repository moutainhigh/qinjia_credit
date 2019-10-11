package com.marvels.dto.sy;

public class SyRequestDto {
	
	private SysHeader sysheader;
	private AppHeader appheader;
	private Object reqdata;

	public SysHeader getSysheader() {
		return sysheader;
	}

	public void setSysheader(SysHeader sysheader) {
		this.sysheader = sysheader;
	}

	public AppHeader getAppheader() {
		return appheader;
	}

	public void setAppheader(AppHeader appheader) {
		this.appheader = appheader;
	}

	public Object getReqdata() {
		return reqdata;
	}

	public void setReqdata(Object reqdata) {
		this.reqdata = reqdata;
	}
}
