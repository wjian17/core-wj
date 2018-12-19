package com.knowledge.accumulation.utils.rsa;

/**
 * @author wj
 */
public class CryptoAlgorithmFactory {
	private Encrypto encrypto;
	public enum CryptoType{
	    DES,RSA,ASE
	} 
	
	public Encrypto getEncrypto(){
		return getEncrypto(CryptoType.RSA);
	}

	public Encrypto getEncrypto(CryptoType type){
		switch(type){
			case DES: 
				encrypto=new DESEncryptoService();
				break;  
	        case RSA: 
	        	encrypto=new RSAEncryptoService();
	        	break;  
	        case ASE: break;  
	        default:
	        	encrypto=new RSAEncryptoService();
		}
		return encrypto;
	}
	
	public Encrypto encrypto(){
		return new RSAEncryptoService();
	}


}
