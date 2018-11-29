package com.maimai.mybatisApp;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AesTest1 {

    private static String src = "abc12332222222222222222222222222222222222223333232323232323232323asdagsdgdgdsgsgdsgsgsgsgsgsgggggggggggggggggggggggggg";
    private static String key = "1231313131";

    @Test
    public void run() throws Exception {

        String en = AesEncrypt(src, key);
        System.out.println(en);
        String de = AesDecrypt(en, key);
        System.out.println(de);

        System.out.println(jdkAES(en,key));




        String encyKey="合作伙伴提供的密钥 ";
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        java.security.SecureRandom random = java.security.SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(encyKey.getBytes());
        kgen.init(128, random);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        BASE64Encoder coder = new BASE64Encoder();
        System.out.println("111111111111---111-"+coder.encode(enCodeFormat));
    }



    private String AesEncrypt(String src, String encodeRules) {

        try {
            // 生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            //keyGenerator.init(128);
            keyGenerator.init(128, new SecureRandom(encodeRules.getBytes()));
            //keyGenerator.init(new SecureRandom());
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();

            // key的转换s
            Key key = new SecretKeySpec(keyBytes, "AES");

            // 加密
            // AES/工作模式/填充方式
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk aes encrypt : " + Base64.encodeBase64String(result));
            return Base64.encodeBase64String(result);

//            // 解密
//            cipher.init(Cipher.DECRYPT_MODE, key);
//            result = cipher.doFinal(result);
//            System.out.println("jdk aes decrypt : " + new String(result));

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    private String AesDecrypt(String src, String encodeRules) {
        byte[] result = Base64.decodeBase64(src);
        try {
            // 生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            //keyGenerator.init(128);
            keyGenerator.init(128, new SecureRandom(encodeRules.getBytes()));
            //keyGenerator.init(new SecureRandom());
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();

            // key的转换
            Key key = new SecretKeySpec(keyBytes, "AES");

            // 加密
            // AES/工作模式/填充方式
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//            cipher.init(Cipher.ENCRYPT_MODE, key);
//            byte[] result = cipher.doFinal(src.getBytes());
//            System.out.println("jdk aes encrypt : " + Base64.encodeBase64String(result));
//            return Base64.encodeBase64String(result);

            // 解密
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result1 = cipher.doFinal(result);
            System.out.println("jdk aes decrypt : " + new String(result1));
            return new String(result1);

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private  String jdkAES(String src, String encodeRules){
        byte[] result = Base64.decodeBase64(src);
        try {
            //生成key
            KeyGenerator keyGenerator= KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom(encodeRules.getBytes()));
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();

            //key转换为密钥
            Key key = new SecretKeySpec(keyBytes, "AES");

            //加密
            Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5padding");
//            cipher.init(Cipher.ENCRYPT_MODE, key);
//            byte[] result = cipher.doFinal(src.getBytes());
//            //System.out.println("jdkAES加密: "+ Hex.encodeHexString(result));  //转换为十六进制
//            System.out.println("jdkAES加密: : " + Base64.encodeBase64String(result));
            //解密
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result1  = cipher.doFinal(result);
            System.out.println("jdkAES解密: "+new String(result1));  //转换字符串
            return new String(result1);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
