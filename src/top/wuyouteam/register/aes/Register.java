package top.wuyouteam.register.aes;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import top.wuyouteam.register.aes.ex.ParamterIsNullException;
import top.wuyouteam.register.aes.tool.AESTool;
/**
 * 注册器关键类。
 * @author  ForMat
 *
 */
public final class Register {
	/**
	 * 关键的KEY，用于AES加密，可按需更改
	 */
	private static final String KEY = "aGEzxK6sBJJfkRdlP+MtbrY/wyHZ4BeLurW1Df3qarE=" ;
	/**
	 * 异常信息字符串
	 */
	private static final String MESSAGE = "您传入的参数为空串或为null!" ;
	/**
	 * 将KEY转为加密解密过程中的数据类型
	 */
	private static SecretKey secretkey = AESTool.strKey2SecretKey(KEY);

	/**
	 * 此方法用于生成注册码
	 * @param androidId 安卓设备的Android Id
	 * @return 注册码
	 */
	public static String createregistercode(String androidId) {
		if("".equals(androidId) || androidId == null) {
			throw new ParamterIsNullException(MESSAGE);
		}
		// 用于接收AES加密结果的数组
		byte[] encryptAESbytes = null;
		// 用于接收结果的字符串
		String result = null;
		try {
			// 尝试用AES进行加密，并赋值给AES加密结果数组
			encryptAESbytes = AESTool.encryptAES(androidId.getBytes("utf-8"), secretkey);
			// 将AES密文转为字符串
			result =  Base64.getEncoder().encodeToString(encryptAESbytes);
		} catch (InvalidKeyException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		}
		return result; 

	}
	
	/**
	 * 此方法用于验证注册码与Android Id是否匹配，匹配则返回true,否则返回false
	 * @param androidId 安卓设备的Id
	 * @param registercode 要匹配的注册码
	 * @return 匹配结果布尔值
	 * @throws top.wuyouteam.register.aes.ex.ParamterIsNullException 当传入的参数为null或空串时会抛出该异常
	 */
	public static boolean checkRegisterCode(String androidId,String registercode) {
		if("".equals(registercode)|| registercode == null || "".equals(androidId)|| androidId == null) {
			throw new ParamterIsNullException(MESSAGE);
		} else if(createregistercode(androidId).equals(registercode)|| createregistercode(androidId).toUpperCase().equals(registercode.toUpperCase())) {
			return true;
		} else {
			return false;
		}
	}

	private Register() {
		// NOOOP
	}



}
