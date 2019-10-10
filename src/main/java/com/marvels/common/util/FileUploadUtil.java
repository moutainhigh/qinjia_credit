package com.marvels.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Files;
import com.marvels.common.util.hexj.utils.EncryptUtil;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * 
 * @author jason
 *
 */
public class FileUploadUtil {

	private static Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);
	
	private static ExecutorService fileSaveExecutor = Executors.newFixedThreadPool(1000);

	/**
	 * 把需要上传的文件根据对应的编码转换成字符串
	 * 
	 * @param file
	 * @param charSet
	 * @return
	 */
	public static String getFileStreamAsString(File file, String charSet) {
		String result = null;
		try {
			FileInputStream in = new FileInputStream(file);
			int size = in.available();
			byte[] buffer = new byte[size];
			in.read(buffer);
			in.close();
			result = new String(buffer, charSet);
		} catch (IOException e) {
			logger.error("Error:", e);
			return null;
		}
		return result;
	}

	/**
	 * 文件上传获取File Stream
	 * @param file
	 * @return
	 */
	public static String[] getUploadFileStream(File file) {
		InputStream input = null;
		ByteArrayOutputStream output = null;
		byte[] data;
		try {
			input = new FileInputStream(file);
			output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			data = output.toByteArray();
			InputStream inputStream = new ByteArrayInputStream(output.toByteArray());
            String myMd5 = multipart2File(inputStream);
			BASE64Encoder base64Encoder = new BASE64Encoder();
			return new String[] { base64Encoder.encode(data), myMd5};
		} catch (IOException e) {
			logger.error("Error:", e);
			return null;
		} finally {
			IOUtils.closeQuietly(output);
			IOUtils.closeQuietly(input);
		}
	}
	
	public static String multipart2File(InputStream stream) {
        String myMd5;
        try {
            byte[] buffer = new byte[1024 * 1024];
            int byteRead;
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            while ((byteRead = stream.read(buffer)) != -1) {
                messagedigest.update(buffer, 0, byteRead);
            }
            myMd5 = EncryptUtil.MD5(messagedigest.digest());
            return myMd5;
        } catch (IOException e) {
            return null;
        } catch (NoSuchAlgorithmException e) {
            return null;
        } finally {
        	IOUtils.closeQuietly(stream);
        }
    }
	
	/**
	 * 异步存储，不影响
	 * @param fileString 文件流
	 * @param filePath 文件名称
	 * @param appl 申请编号
	 */
	public static void saveFile(String fileString, String filePath) {
		fileSaveExecutor.submit(new Runnable() {
			
			@Override
			public void run() {
				FileOutputStream outputStream = null;
				try {
					byte[] bytes = new BASE64Decoder().decodeBuffer(fileString);
					File file = new File(filePath);
		            outputStream = new FileOutputStream(file);
		            outputStream.write(bytes, 0, bytes.length);
				} catch (IOException e) {
					logger.error("error:", e);
				} finally {
					IOUtils.closeQuietly(outputStream);
				}
			}
		});
		
	}
	
	public static String getSavedFileFolder(String fileType) {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		String sDate = df.format(date);
		String folderName = "datafile/"+fileType+"/"+sDate;
		File file = new File(folderName+"/tmp.dat");
		if (!file.exists()) {
			try {
				Files.createParentDirs(file);
			} catch (IOException e) {
				logger.error("error:", e);
			}
		}
		return folderName;
	}

	public static String getFileSuffix(String filename) {
		if (filename.contains(".")) {
			return filename.substring(filename.lastIndexOf("."), filename.length());
		} 
		return filename;
	}
	
}
