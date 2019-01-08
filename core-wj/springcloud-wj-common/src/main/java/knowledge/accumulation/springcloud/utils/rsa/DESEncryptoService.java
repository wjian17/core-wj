package knowledge.accumulation.springcloud.utils.rsa;

/**
 * @author wj
 */
public class DESEncryptoService implements Encrypto {

	
	public String encrypt(String plainText) {
		return EncryptionAlgorithm.encryptionAlgorithm.desEncrypt(plainText);
	}


	public String decrypt(String encryptStr) {
		return EncryptionAlgorithm.encryptionAlgorithm.desDecrypt(encryptStr);
	}

	public byte[] encryptByte(byte[] plainBytes){
		return EncryptionAlgorithm.encryptionAlgorithm.encryptByte(plainBytes);
	}

	public byte[] decryptByte(byte[] encryptBytes){
		return EncryptionAlgorithm.encryptionAlgorithm.decryptByte(encryptBytes);
	}

}
