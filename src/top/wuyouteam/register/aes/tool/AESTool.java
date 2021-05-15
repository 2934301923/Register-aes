package top.wuyouteam.register.aes.tool;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
/**
 * 此类为AES工具类，封装了AES常用的算法
 * @author ForMat
 * @since JDK 1.8
 * @version 1.0.0
 */
public final class AESTool {
	/**
	 * 此方法用于随机获取一个AES密钥
	 * @return AES密钥
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String getStrKeyAES() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		SecureRandom secureRandom = new SecureRandom(String.valueOf(System.currentTimeMillis()).getBytes("utf-8"));
		keyGen.init(256, secureRandom);  
		SecretKey secretKey = keyGen.generateKey();
		return Base64.getEncoder().encodeToString(secretKey.getEncoded());
	}

	/**
	 * 此方法用于将AES密钥转为Base64
	 * @param strKey AES密钥
	 * @return Baese64编码的AES密钥
	 */
	public static SecretKey strKey2SecretKey(String strKey){
		byte[] bytes = Base64.getDecoder().decode(strKey);
		SecretKeySpec secretKey = new SecretKeySpec(bytes, "AES");
		return secretKey;
	}

	/**
	 * 此方法用于aes加密
	 * @param content 要加密的内容
	 * @param secretKey aes密钥
	 * @return 加密后的密文 byte[]
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @sine JDK 1.8
	 */
	public static byte[] encryptAES(byte[] content, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		return cipher.doFinal(content);
	}

	/**
	 * 此方法用于解密
	 * @param content 要解密的内容
	 * @param secretKey 密钥
	 * @return 解密后的明文  byte[]
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public static byte[] decryptAES(byte[] content, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		return cipher.doFinal(content);
	}



	/**
	 * 私有构造器
	 */
	private AESTool() {

	}

}
