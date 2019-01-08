package knowledge.accumulation.springcloud.utils.rsa;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wj
 */
public class EncryptionAlgorithm {
	public static String key = "GRG20170525";
	public static byte[] keyBytes;


	private static CryptoManager cryptoManager;
	private final static Logger logger = LoggerFactory
			.getLogger(EncryptionAlgorithm.class);

	public static EncryptionAlgorithm encryptionAlgorithm = new EncryptionAlgorithm();

    public String rsaEncryptByPublicKey(String plainText){
    	try {
    		if(logger.isInfoEnabled()){
    			logger.info("RSA明文 " + plainText);
    		}
    		String encrypt = cryptoManager.rsaEncryptByPublicKey(plainText);
    		if(logger.isInfoEnabled()){
    			logger.info("RSA密文 " + encrypt);
    		}
			return encrypt;
		} catch (Exception e) {
			throw new RuntimeException("RSA公钥加密失败",e);
		}
    }

	public String rsaEncryptByPrivateKey(String plainText){
		try {
			if(logger.isInfoEnabled()){
				logger.info("RSA明文 " + plainText);
			}
			String encrypt = cryptoManager.rsaEncryptByPrivateKey(plainText);
			if(logger.isInfoEnabled()){
				logger.info("RSA密文 " + encrypt);
			}
			return encrypt;
		} catch (Exception e) {
			throw new RuntimeException("RSA私钥加密失败",e);
		}
	}

	public String rsaDecryptByPublicKey(String encryptStr){
		try {
			if(logger.isInfoEnabled()){
				logger.info("RSA密文 " + encryptStr);
			}
			String plainText=cryptoManager.rsaDecryptByPublicKey(encryptStr);
			if(logger.isInfoEnabled()){
				logger.info("RSA明文 " + plainText);
			}
			return plainText;
		} catch (Exception e) {
			throw new RuntimeException("RSA公钥解密失败",e);
		}
	}
    
    public String rsaDecryptByPrivateKey(String encryptStr){
    	try {
    		if(logger.isInfoEnabled()){
    			logger.info("RSA密文 " + encryptStr);
    		}
    		String plainText=cryptoManager.rsaDecryptByPrivateKey(encryptStr);
    		if(logger.isInfoEnabled()){
    			logger.info("RSA明文 " + plainText);
    		}
			return plainText;
		} catch (Exception e) {
			throw new RuntimeException("RSA私钥解密失败",e);
		}
    }
    
    public String desEncrypt(String plainText){
    	try {
//    		if(logger.isDebugEnabled()){
//    			logger.debug("DES明文 " + plainText);
//    		}
			String encrypt = cryptoManager.desEncrypt(plainText, keyBytes);
//    		if(logger.isDebugEnabled()){
//    			logger.debug("DES密文 " + encrypt);
//    		}
			return encrypt;
		} catch (Exception e) {
			throw new RuntimeException("DES加密失败",e);
		}
    }
    
    public String desDecrypt(String encryptStr){
    	try {
//    		if(logger.isDebugEnabled()){
//    			logger.debug("DES密文 " + encryptStr);
//    		}
    		
    		String plainText = cryptoManager.desDecrypt(encryptStr, keyBytes);
//    		if(logger.isDebugEnabled()){
//    			logger.debug("DES明文 " + plainText);
//    		}
			return plainText;
		} catch (Exception e) {
			throw new RuntimeException("DES解密失败",e);
		}
    }

    public byte[] encryptByte(byte[] plainBytes){
		try {
			byte[] encryptBytes = cryptoManager.desEncryptByte(plainBytes, keyBytes);
			return encryptBytes;
		} catch (Exception e) {
			throw new RuntimeException("DES加密二进制失败",e);
		}
	}

	public byte[] decryptByte(byte[] encryptBytes){
		try {
			byte[] decryptBytes = cryptoManager.desDecryptByte(encryptBytes, keyBytes);
			return decryptBytes;
		} catch (Exception e) {
			throw new RuntimeException("DES解密二进制失败",e);
		}
	}
    
    private EncryptionAlgorithm(){
			//rsa_public_key.pem
			String pubKeyStr = null;
			String privateKeyStr = null;
			Resource[] pubKeyResources = null;
			Resource[] priKeyResources = null;
			try {
				pubKeyResources = new PathMatchingResourcePatternResolver().getResources("classpath:rsa_public_key.pem");
				priKeyResources = new PathMatchingResourcePatternResolver().getResources("classpath:pkcs8_private_key.pem");
				if(null != pubKeyResources && pubKeyResources.length > 0){
					pubKeyStr = getKeyFromFile(pubKeyResources[0].getInputStream());
				}
				if(null != priKeyResources && priKeyResources.length > 0){
					privateKeyStr = getKeyFromFile(priKeyResources[0].getInputStream());
				}
			}catch (FileNotFoundException e){
				logger.error("密钥文件不存在", e);
			} catch (IOException e) {
				e.printStackTrace();
			}
		cryptoManager = new CryptoManager(privateKeyStr, pubKeyStr);
    }

	private static String getKeyFromFile(InputStream in) {
		String key = null;
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(in));
			List<String> list = new ArrayList<String>();
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				list.add(line);
			}
			StringBuilder stringBuilder = new StringBuilder();
			// 去掉第一行和最后一行
			for (int i = 1; i < list.size() - 1; i++) {
				stringBuilder.append(list.get(i)).append("\r");
			}
			key = stringBuilder.toString();
		} catch (FileNotFoundException e) {
			logger.error("{}", e);
		} catch (IOException e) {
			logger.error("{}", e);
		} finally{
			if(null != bufferedReader){
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return key;
	}

}
