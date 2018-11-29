package com.maimai.mybatisApp;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DesTest {

    private static String src = "Hello Base64";

    @Test
    public void run() {

        jdkBase64();
        commonscodecBase64();

    }

    public void jdkBase64() {
        try {
            BASE64Encoder encoder = new BASE64Encoder();
            String encode = encoder.encode(src.getBytes());
            System.out.println("encode: " + encode);
            log.info("encode: " + encode);

            BASE64Decoder decoder = new BASE64Decoder();
            String decode = new String(decoder.decodeBuffer(encode));
            System.out.println("decode: " + decode);
            log.info("decode: " + decode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void commonscodecBase64() {
        byte[] encode = Base64.encodeBase64(src.getBytes());
        System.out.println("encode: " + new String(encode));  //需要转化为String
        log.info("encodeBase64String:" + Base64.encodeBase64String(src.getBytes()));
        log.info("encodeBase64String:" + new String( Base64.decodeBase64(Base64.encodeBase64String(src.getBytes()))));
        byte[] decode = Base64.decodeBase64(encode);


        byte[] e=src.getBytes();
        System.out.println("e: " + new String(e));  //需要转化为String
    }


}
