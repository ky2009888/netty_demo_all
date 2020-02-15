package com.ky2009666.apps.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * netty 客户端
 *
 * @author Lenovo
 */
@Slf4j
public class NettyClient01 {
    public static void main(String[] args) {
        //在客户端创建一个事件循环组
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        /**
         * 创建客户端启动对象
         * 客户端使用的对象是Bootstrap
         */
        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                //设置线程组
                .group(eventExecutors)
                //设置客户端通道的实现类,通过反射的方式
                .channel(NioSocketChannel.class)
                //添加handler的处理实现类
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new NettyClientHandler());
                    }
                });
        log.info("客户端已经准备好");
        try {
            ChannelFuture future = bootstrap.connect("127.0.0.1", 8989).sync();
            //给关闭通道启动监听，不是马上关闭通道
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventExecutors.shutdownGracefully();
        }
    }
}
