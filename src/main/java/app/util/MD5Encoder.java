package app.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encoder {
	
	private MD5Encoder() {
	}
	
	public static String encode(String base) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md5.update(StandardCharsets.UTF_8.encode(base));
		return String.format("%032x", new BigInteger(1, md5.digest()));
	}
}
