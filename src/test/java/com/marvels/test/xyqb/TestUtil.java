package com.marvels.test.xyqb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSON;

public class TestUtil {
	
	private static final String test_data_file_dir = "C:\\Users\\Administrator\\git\\ykg_credit_wallet_system\\src\\main\\file";

	public static <T> T  parseTestDate(String fileName,Class<T> clazz){
		
		 StringBuffer lineTxt = new StringBuffer();
		String linetxttmp = new String();
        try {
            String encoding = "UTF-8";
            File file = new File(test_data_file_dir+"/"+fileName);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                while ((linetxttmp = bufferedReader.readLine()) != null) {
                    lineTxt.append(linetxttmp);
                }
                read.close();
                System.out.println(lineTxt.toString());
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        
       return  JSON.parseObject(lineTxt.toString(), clazz);
	}
	
}
