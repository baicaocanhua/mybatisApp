package com.maimai.mybatisApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * Created by maimai on 2018-04-25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NIO测试 {
    @Test
    public void Test() {
        System.out.println(333);
        try {
            RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
            FileChannel inChannel = aFile.getChannel();  //从一个InputStream outputstream中获取channel
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);//首先给Buffer分配空间，以字节为单位
            int bytesRead = inChannel.read(byteBuffer);

            WriteData(inChannel);

            while (bytesRead != -1) {
                byteBuffer.flip();  //make buffer ready for read
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get()); // read 1 byte at a time
                }
                byteBuffer.clear(); //make buffer ready for writing
                bytesRead = inChannel.read(byteBuffer);
            }
            aFile.close();
        } catch (Exception e) {

        }
    }

    private void WriteData(FileChannel channel) throws IOException {
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();
        while(buf.hasRemaining()) {
            channel.write(buf);
        }
    }
}


