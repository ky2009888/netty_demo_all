package com.ky2009666.apps.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO服务端代码
 *
 * @author Lenovo
 */
@Slf4j
public class BioServer {

    public static void main(String[] args) throws IOException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(9999);
        log.info("服务器已经启动---------------------");
        while (true) {
            //监听，等待客户端连接
            final Socket socket = server.accept();
            log.info("连接到一个客户端");
            threadPool.execute(new Runnable() {
                public void run() {
                    try {
                        handleClient(socket);
                    } catch (IOException e) {
                        log.error(e.getMessage());
                    }
                }
            });
        }
    }

    /**
     * 处理线程内容
     *
     * @param socket
     * @throws IOException
     */
    private static void handleClient(Socket socket) throws IOException {
        log.info("当前线程的ID：{}",Thread.currentThread().getId());
        byte[] readContent = new byte[1024];
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            while (true) {
                int readPosition = inputStream.read(readContent);
                if (readPosition != -1) {
                    String content = new String(readContent, 0, readPosition);
                    log.info("输出客户端发送的数据:{}", content);
                }
            }
        } catch (IOException e) {

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
