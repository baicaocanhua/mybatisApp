package com.maimai.mybatisApp;


import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AesTest {

    private static String src = "abc12332222222222222222222222222222222222223333232323232323232323asdagsdgdgdsgsgdsgsgsgsgsgsgggggggggggggggggggggggggg";
    private static String key = "1234567812345678";
    @Test
    public void run() throws Exception {
        jdkAES1();
        jdkAES();

        jdkAES1();
        jdkAES();

        String en=aesEncrypt(src,key);
        System.out.println("en:======"+en);
        String de=aesDecrypt(en,key);
        System.out.println("de:======"+de);

        encrypt(src,"1111");

    }

    private  void jdkAES1() {

        try {
            String encodeRules="ppmcloud";
            // 生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            //keyGenerator.init(128);
            keyGenerator.init(128,new SecureRandom(encodeRules.getBytes()));
            //keyGenerator.init(new SecureRandom());
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keybytes = secretKey.getEncoded();

            // key的转换
            Key key = new SecretKeySpec(keybytes, "AES");

            // 加密
            // AES/工作模式/填充方式
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk aes encrypt : " + Base64.encodeBase64String(result));

            // 解密
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(result);
            System.out.println("jdk aes decrypt : " + new String(result));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private  void jdkAES(){
        try {
            //生成key
            KeyGenerator keyGenerator= KeyGenerator.getInstance("AES");
            keyGenerator.init(new SecureRandom());
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] key1 = secretKey.getEncoded();

            //key转换为密钥
            Key key2 = new SecretKeySpec(key1, "AES");

            //加密
            Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5padding");
            cipher.init(Cipher.ENCRYPT_MODE, key2);
            byte[] result = cipher.doFinal(src.getBytes());
            //System.out.println("jdkAES加密: "+ Hex.encodeHexString(result));  //转换为十六进制
            System.out.println("jdkAES加密: : " + Base64.encodeBase64String(result));
            //解密
            cipher.init(Cipher.DECRYPT_MODE, key2);
            result = cipher.doFinal(result);
            System.out.println("jdkAES解密: "+new String(result));  //转换字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private  String aesEncrypt(String str, String key) throws Exception {
        if (str == null || key == null) return null;
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"));
        byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));
        String en=new BASE64Encoder().encode(bytes);
        return en;
    }

    private  String aesDecrypt(String str, String key) throws Exception {
        if (str == null || key == null) return null;
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"));
        byte[] bytes = new BASE64Decoder().decodeBuffer(str);
        bytes = cipher.doFinal(bytes);
        String de= new String(bytes, "utf-8");
        return de;
    }

   private String encrypt(String content, String password) {
        try {
            //如下代码用于根据原始的password生成加密的key，这段代码C#是没有对应的实现的
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            java.security.SecureRandom random = java.security.SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();

            //如下代码是标准的AES加密处理，C#可以实现
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result=cipher.doFinal(byteContent);

            return  Base64.encodeBase64String(result);
        } catch (Exception e) {

        }
        return null;
    }
}
