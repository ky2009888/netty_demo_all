package com.ky2009666.apps.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * 通过拷贝文件FileChannel
 *
 * @author Lenovo
 */
public class CopyFileByChannel {
    /**
     * 演示文件复制的案例
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("F:\\workspace-selfService-20200109\\netty_demo_all\\nio_demo_01\\src\\main\\resources\\druid-1.0.9.jar");
        FileChannel sourceJarChannel = inputStream.getChannel();
        FileOutputStream outputStream = new FileOutputStream("F:\\workspace-selfService-20200109\\netty_demo_all\\nio_demo_01\\src\\main\\resources\\druid-1.0.9_backup.jar");
        FileChannel targetJarChannel = outputStream.getChannel();
        targetJarChannel.transferFrom(sourceJarChannel, 0, sourceJarChannel.size());
        sourceJarChannel.close();
        targetJarChannel.close();
        inputStream.close();
        outputStream.close();
    }
}
