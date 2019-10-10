package com.marvels.common.util.hexj.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReqNoUtil {
	
	private static Integer LOAN_ID_SEQ = 0;

	public static synchronized String generateSerno() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		StringBuilder sb = new StringBuilder();
		if (LOAN_ID_SEQ > 99) {
			LOAN_ID_SEQ = 0;
		}
		// 2位自增长
		String autoSeq = String.format("%02d", LOAN_ID_SEQ);
		sb.append(sdf.format(new Date())).append(autoSeq);
		LOAN_ID_SEQ++;
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(ReqNoUtil.generateSerno());
	}
}
