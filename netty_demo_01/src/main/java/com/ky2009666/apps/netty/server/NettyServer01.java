package com.ky2009666.apps.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * netty服务器
 *
 * @author Lenovo
 */
@Slf4j
public class NettyServer01 {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 创建两个线程组
         * bossGroup：进行请求转发处理
         * workerGroup：处理业务
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //创建服务器启动对象，配置参数
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        try {
            //使用链式编程，设置相关的参数
            //设置两个线程组
            serverBootstrap.group(bossGroup, workerGroup)
                    //使用NioServerSocketChannel作为服务器的channel
                    .channel(NioServerSocketChannel.class)
                    //设置线程队列得到的连接个数
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //设置保持活动连接状态
                    .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
                    //给我们的workerGroup的EventLoopGroup的对应管道的设置处理器
                    .childHandler(
                            new ChannelInitializer<SocketChannel>() {
                                /**
                                 * 创建一个通道的测试对象
                                 *
                                 * @param socketChannel
                                 * @throws Exception
                                 */
                                @Override
                                protected void initChannel(SocketChannel socketChannel) throws Exception {
                                    //在管道的后面增加处理
                                    socketChannel.pipeline().addLast(new NettyServer01Handler());
                                }
                            }
                    );
            log.info(".......服务器已经准备好..................");
            //绑定端口号,并同步生成一个ChannelFuture对象，启动服务器
            ChannelFuture channelFuture = serverBootstrap.bind(8989).sync();
            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            //优雅的关闭请求
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}