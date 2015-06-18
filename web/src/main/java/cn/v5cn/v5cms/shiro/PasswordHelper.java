package cn.v5cn.v5cms.shiro;

import cn.v5cn.v5cms.util.TwoTuple;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by ZYW on 2014/10/27.
 */
@Service
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Value("${password.algorithmName}")
    private String algorithmName="md5";
    @Value("${password.hashIterations}")
    private int hashIterations=2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    /**
     * @return 返回一个包含两个原始的元组，第一个是生成的盐，第二个是密码
     * */
    public TwoTuple<String,String> encrypt(String original,String mix){
        String salt = randomNumberGenerator.nextBytes().toHex();
        String pwd = new SimpleHash(algorithmName,
                original,
                ByteSource.Util.bytes(getCredentialsSalt(mix,salt)),
                hashIterations).toHex();
        return new TwoTuple<String,String>(salt,pwd);
    }
    /**
     * 字符串混淆
     * */
    public static String getCredentialsSalt(String mix1,String mix2) {
        return mix1 + mix2;
    }

//    public static void main(String[] args) {
//        PasswordHelper passwordHelper = new PasswordHelper();
//        TupleTwo<String, String> zhangsan = passwordHelper.encrypt("000000", "zhangsan");
//        System.out.println(zhangsan.a);
//        System.out.println(zhangsan.b);
//    }
}
