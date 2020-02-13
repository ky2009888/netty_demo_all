package com.ky2009666.apps.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 演示文件读写的使用方法
 *
 * @author Lenovo
 */
@Slf4j
public class FileChannelWriteDemo {
    public static void main(String[] args) throws IOException {
        String fileReadPath = "F:\\workspace-selfService-20200109\\netty_demo_all\\nio_demo_01\\src\\main\\resources\\read.txt";
        String fileWritePath = "F:\\workspace-selfService-20200109\\netty_demo_all\\nio_demo_01\\src\\main\\resources\\write.txt";
        FileInputStream fileInputStream = new FileInputStream(fileReadPath);
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream(fileWritePath);
        FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            byteBuffer.clear();
            int read = fileInputStreamChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            //反转
            byteBuffer.flip();
            fileOutputStreamChannel.write(byteBuffer);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
