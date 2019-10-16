package com.marvels.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class SerialGenerator {
	private static final Object OBJECT = new Object();
    private static long bIndex = 0;

    /**
     * 可用多线程检测是否会产生相同随机数
     * @param length
     * @return
     */
    public static String createSerialNo(int length) {
        double max = Math.pow(10, length);
        String curSerial;
        synchronized (OBJECT) {
            if (++bIndex >= max){
                bIndex = 0;
            }
            curSerial = bIndex + "";
        }
        while (curSerial.length() < length) {
            curSerial = "0" + curSerial;
        }
        return curSerial;
    }

    public static String get13Random(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmssSSS");
        String now = sdf.format(new Date());
        return now + createSerialNo(5);
    }



    public static void main(String[] args) {
    	//;
    	for (int i = 0; i < 50; i++) {

            System.out.println(System.currentTimeMillis());
            System.out.println(get13Random());

        }
	}
}
