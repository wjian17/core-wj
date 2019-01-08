package knowledge.accumulation.springcloud.utils.base64;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64转换器，提供Base64转换的基本操作
 * @author wangyafei
 * @version 1.0
 *
 */
public class Base64Util {

	
	/**
	 * Encodes binary data using the base64 caller but does not chunk the output.
	 * @param binaryData
	 * @return
	 */
	public static byte[] encodeBase64(byte[] binaryData) throws Exception{
		return Base64.encodeBase64(binaryData);
	}
	
	/**
	 * Encodes string data using the base64 caller but does not chunk the output.
	 * @param strData
	 * @return
	 */
	public static byte[] encodeBase64(String strData) throws Exception{
		return Base64.encodeBase64(strData.getBytes("utf-8"));
	}
	
	/**
	 * 将二进制数组转为base64字符串
	 * @param binaryData
	 * @return
	 * @throws Exception
	 */
	public static String encodeBase64Byte2Str(byte[] binaryData) throws Exception{
		byte[] b = Base64.encodeBase64(binaryData);
		return new String(b, "utf-8");
	}
	
	/**
	 * 将数据字符串转换为Base64字符串 
	 * @param strData
	 * @return
	 * @throws Exception
	 */
	public static String encodeBase64Str2Str(String strData) throws Exception{
		byte[] b = Base64.encodeBase64(strData.getBytes("utf-8"));
		return new String(b, "utf-8");
	}
	
	/**
	 * Decodes a Base64 String into octets.
	 * 
	 * @param base64String
	 * @return
	 */
	public static byte[] decodeBase64(String base64String) throws Exception{
		return Base64.decodeBase64(base64String);
	}
	
	/**
	 * 将base64字符串转换为数据字符串
	 * @param base64String
	 * @return
	 */
	public static String decodeBase64Str2Str(String base64String) throws Exception{
		byte[] b = Base64.decodeBase64(base64String);
		return new String(b, "utf-8");
	}
}
