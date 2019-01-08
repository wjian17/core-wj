package knowledge.accumulation.springcloud.utils.rsa;

/**
 * @author wj
 * 处理加减密公共接口
 */
public interface Encrypto {
    String encrypt(String plainText);
    String decrypt(String encryptStr);
}
