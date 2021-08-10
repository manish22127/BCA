package Steganography;

import java.io.FileInputStream;
import java.security.MessageDigest;

public class SHA_256 {

	public static String hash(String path) {
		StringBuffer sb=null;
		try {
			String datafile = path;
			
		    MessageDigest md = MessageDigest.getInstance("SHA-256");
		    FileInputStream fis = new FileInputStream(datafile);
		    byte[] dataBytes = new byte[1024];
		 
		    int nread = 0; 
		 
		    while ((nread = fis.read(dataBytes)) != -1) {
		      md.update(dataBytes, 0, nread);
		    };
		 
		    byte[] mdbytes = md.digest();

		    sb= new StringBuffer("");
		    for (int i = 0; i < mdbytes.length; i++) {
		    	sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
		    }
		 
		    System.out.println(sb.toString());
		   
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return sb.toString();
	}
	
}
