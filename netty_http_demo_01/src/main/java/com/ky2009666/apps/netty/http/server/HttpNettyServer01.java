package com.ky2009666.apps.netty.http.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.nio.channels.ServerSocketChannel;

/**
 * http netty server的案例演示
 *
 * @author Lenovo
 */
@Slf4j
public class HttpNettyServer01 {
    public static void main(String[] args) {
        /**
         * 定义两个线程组
         * bossGroup：负责处理请求链接
         * workerGroup：负责处理请求业务相关
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            serverBootstrap
                    .group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new HttpNettyServer01Initializer());
            ChannelFuture channelFuture = serverBootstrap.bind(9999).sync();
            //为后面关闭注册事件
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();

        }
    }
}
