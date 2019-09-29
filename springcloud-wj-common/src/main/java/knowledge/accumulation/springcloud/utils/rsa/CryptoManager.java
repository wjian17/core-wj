package knowledge.accumulation.springcloud.utils.rsa;

import knowledge.accumulation.springcloud.utils.base64.Base64Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author wj
 */
public class CryptoManager {
    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;

    private static final Logger logger = LoggerFactory.getLogger(CryptoManager.class);

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    public RSAPublicKey getPublicKey() {
        return publicKey;
    }

    public CryptoManager(String privateKeyStr, String publicKeyStr) {
        try {
            this.setPrivateKey(privateKeyStr);
            this.setPublicKey(publicKeyStr);
        } catch (Exception e) {
            throw new RuntimeException("秘钥文件处理失败", e);
        }
    }

    public void setPublicKey(String publicKeyStr) throws Exception {
        try {
            byte[] buffer = Base64Util.decodeBase64(publicKeyStr);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(buffer);
            this.publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法");
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            throw new Exception("私钥非法");
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("私钥字符串读取出错");
        }
    }

    public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKeyStr) throws Exception {
        try {
            byte[] buffer = Base64Util.decodeBase64(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(buffer);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            this.privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法", e);
        } catch (InvalidKeySpecException e) {
            throw new Exception("私钥非法", e);
        } catch (IOException e) {
            throw new Exception("私钥字符串读取出错", e);
        }
    }

    /**
     * 公钥加密
     * @param text
     * @return
     * @throws Exception
     */
    public String rsaEncryptByPublicKey(String text) throws Exception {
        if (this.publicKey == null) {
            throw new Exception("请先设置公钥");
        }
        Cipher cipher = null;
        String encryptStr = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, this.publicKey);
            byte[] base64Data = Base64Util.encodeBase64(text);
//            byte[] encryptedData = this.rsaEncrypt(cipher, base64Data);
            byte[] encryptedData = rsaEncryptAndDecrypt(cipher, base64Data, MAX_ENCRYPT_BLOCK);
            encryptStr = Base64Util.encodeBase64Byte2Str(encryptedData);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法", e);
        } catch (NoSuchPaddingException e) {
            //e.printStackTrace();
            throw new Exception("PKCS1Padding非法", e);
        } catch (InvalidKeyException e) {
            throw new Exception("私钥非法", e);
        }
        return encryptStr;
    }

    /**
     * 私钥加密
     * @param text
     * @return
     * @throws Exception
     */
    public String rsaEncryptByPrivateKey(String text) throws Exception {
        if (this.publicKey == null) {
            throw new Exception("请先设置私钥");
        }
        Cipher cipher = null;
        String encryptStr = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, this.privateKey);
            byte[] base64Data = Base64Util.encodeBase64(text);
//            byte[] encryptedData = this.rsaEncrypt(cipher, base64Data);
            byte[] encryptedData = rsaEncryptAndDecrypt(cipher, base64Data, MAX_ENCRYPT_BLOCK);
            encryptStr = Base64Util.encodeBase64Byte2Str(encryptedData);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法", e);
        } catch (NoSuchPaddingException e) {
            throw new Exception("PKCS1Padding非法", e);
        } catch (InvalidKeyException e) {
            throw new Exception("私钥非法", e);
        }
        return encryptStr;
    }

    /**
     * 公钥解密
     * @param text
     * @return
     * @throws Exception
     */
    public String rsaDecryptByPublicKey(String text) throws Exception {
        if (this.privateKey == null) {
            throw new Exception("请先设置公钥");
        }
        Cipher cipher = null;
        String decryptStr = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, this.publicKey);
            byte[] encryptDataArr = Base64Util.decodeBase64(text);
            byte[] decryptedData = rsaEncryptAndDecrypt(cipher, encryptDataArr, MAX_DECRYPT_BLOCK);
            decryptStr = Base64Util.decodeBase64Str2Str(new String(decryptedData));
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法", e);
        } catch (NoSuchPaddingException e) {
            //e.printStackTrace();
            throw new Exception("PKCS1Padding非法", e);
        } catch (InvalidKeyException e) {
            throw new Exception("私钥非法", e);
        }
        return decryptStr;
    }

    /**
     * 私钥解密
     * @param text
     * @return
     * @throws Exception
     */
    public String rsaDecryptByPrivateKey(String text) throws Exception {
        if (this.privateKey == null) {
            throw new Exception("请先设置私钥");
        }
        Cipher cipher = null;
        String decryptStr = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, this.privateKey);
            byte[] encryptDataArr = Base64Util.decodeBase64(text);
            byte[] decryptedData = rsaEncryptAndDecrypt(cipher, encryptDataArr, MAX_DECRYPT_BLOCK);
            decryptStr = Base64Util.decodeBase64Str2Str(new String(decryptedData));
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此加密算法", e);
        } catch (NoSuchPaddingException e) {
            //e.printStackTrace();
            throw new Exception("PKCS1Padding非法", e);
        } catch (InvalidKeyException e) {
            throw new Exception("私钥非法", e);
        }
        return decryptStr;
    }

    /**
     * RSA分段加减密
     * @param cipher
     * @param encryptDataArr
     * @param maxBlock
     * @return
     * @throws Exception
     */
    public byte[] rsaEncryptAndDecrypt(Cipher cipher, byte[] encryptDataArr, int maxBlock) throws Exception{
        int inputLen = encryptDataArr.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > maxBlock) {
                cache = cipher.doFinal(encryptDataArr, offSet, maxBlock);
            } else {
                cache = cipher.doFinal(encryptDataArr, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * maxBlock;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    public String desEncrypt(String text, byte[] key) throws Exception {
        Cipher cipher = null;
        String encryptStr = null;
        try {
            byte[] iv = {1, 2, 3, 4, 5, 6, 7, 8};
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
            byte[] encryptData = cipher.doFinal(text.getBytes());
            //encryptStr = new BASE64Encoder().encode(encryptData);
            encryptStr = Base64Util.encodeBase64Byte2Str(encryptData);
        } catch (Exception e) {
            throw new Exception("加密失败", e);
        }
        return encryptStr;

    }

    public String desDecrypt(String text, byte[] key) throws Exception {
        Cipher cipher = null;
        String decryptStr = null;
        try {
            byte[] iv = {1, 2, 3, 4, 5, 6, 7, 8};
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(key);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
            //byte[] encryptData = new BASE64Decoder().decodeBuffer(text);
            byte[] encryptData = Base64Util.decodeBase64(text);
            byte[] decryptData = cipher.doFinal(encryptData);
            decryptStr = new String(decryptData);
        } catch (Exception e) {
            throw new Exception("解密非法", e);
        }
        return decryptStr;

    }

    public byte[] desEncryptByte(byte[] bytes, byte[] key) throws Exception {
        Cipher cipher = null;
        String encryptStr = null;
        try {
            byte[] iv = {1, 2, 3, 4, 5, 6, 7, 8};
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
//            DESKeySpec desKeySpec = new DESKeySpec(key);
//            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
//            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            cipher.init(Cipher.ENCRYPT_MODE, getKey(key), ivParameterSpec);
            byte[] encryptData = cipher.doFinal(bytes);
            return encryptData;
        } catch (Exception e) {
            throw new Exception("加密失败", e);
        }
    }

    public byte[] desDecryptByte(byte[] bytes, byte[] key) throws Exception {
        Cipher cipher = null;
        String decryptStr = null;
        try {
            byte[] iv = {1, 2, 3, 4, 5, 6, 7, 8};
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
//            DESKeySpec desKeySpec = new DESKeySpec(key);
//            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
//            keyFactory.generateSecret(desKeySpec);
//            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            cipher.init(Cipher.DECRYPT_MODE, getKey(key), ivParameterSpec);
            //byte[] encryptData = new BASE64Decoder().decodeBuffer(text);
//            byte[] encryptData = Base64Util.decodeBase64(text);
            byte[] decryptData = cipher.doFinal(bytes);
//            decryptStr = new String(decryptData);
            return decryptData;
        } catch (Exception e) {
            throw new Exception("解密非法", e);
        }
    }

    private Key getKey(byte[] key){
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            DESKeySpec keySpec = new DESKeySpec(key);
//            keyFactory.generateSecret(keySpec);
            return keyFactory.generateSecret(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
