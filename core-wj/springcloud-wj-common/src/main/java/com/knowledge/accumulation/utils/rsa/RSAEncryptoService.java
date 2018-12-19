package com.knowledge.accumulation.utils.rsa;

/**
 * @author wj
 */
public class RSAEncryptoService implements Encrypto{

	public RSAEncryptoService(){
		
	}

	public String encrypt(String plainText) {
		return EncryptionAlgorithm.encryptionAlgorithm.rsaEncryptByPublicKey(plainText);
	}


	public String decrypt(String encryptStr) {
		return EncryptionAlgorithm.encryptionAlgorithm.rsaDecryptByPrivateKey(encryptStr);
	}

	public String encryptByPrivateKey(String plainText){
		return EncryptionAlgorithm.encryptionAlgorithm.rsaEncryptByPrivateKey(plainText);
	}

	public String decryptByPublicKey(String encryptStr){
		return EncryptionAlgorithm.encryptionAlgorithm.rsaDecryptByPublicKey(encryptStr);
	}

}
