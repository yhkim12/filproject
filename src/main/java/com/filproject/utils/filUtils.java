package com.filproject.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;


public class filUtils {
	
	private static Logger log = Logger.getLogger(filUtils.class);
	
	private static MessageDigest md;
    static {
    	
        try{
            md = MessageDigest.getInstance("MD5");
        }catch(Exception e){
            md = null;
        }
    }
    
    private static byte[] md5(String source) {
        byte[] bytes = source.getBytes();
        byte[] digest = md.digest(bytes);
        return digest;
    }
    
	//사용 예
	// name="memberPw"
	
	//String memberPwTemp =  SeedUtils.getSeedMD5Code(memberPw);
	//memberPw = SeedUtils.getSeedSHA256Code(memberPwTemp);
	
    
    //1차암호화
	public static String getFilMD5Code(String str){

		String MD5 = ""; 
		
		 try{
			 
			 MessageDigest md = MessageDigest.getInstance("MD5"); 
			 md.update(str.getBytes()); 
			 byte byteData[] = md.digest();
			 StringBuffer sb = new StringBuffer(); 
			 for(int i = 0 ; i < byteData.length ; i++){
				 sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			 }
			 MD5 = sb.toString();
		 }catch(NoSuchAlgorithmException e){
			 log.error("filUtils getFilMD5Code Error");
			 MD5 = ""; 
		 }
		 
		 return MD5;
	}
	
	//2차 암호화
	public static String getFilSHA256Code(String str){

		String SHA256 = ""; 
		
		 try{
			 
			 MessageDigest md = MessageDigest.getInstance("SHA-256"); 
			 md.update(str.getBytes()); 
			 byte byteData[] = md.digest();
			 StringBuffer sb = new StringBuffer(); 
			 for(int i = 0 ; i < byteData.length ; i++){
				 sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			 }
			 SHA256 = sb.toString();
		 }catch(NoSuchAlgorithmException e){
			 log.error("FilUtils getFilSHA256Code Error");
			 SHA256 = ""; 
		 }
		 
		 return SHA256;
	}

}
