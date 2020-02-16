package com.ky2009666.apps.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义一个handler，需要继承netty规定好的某个handler适配器
 * 这时，我们自定义的handler才能称之为一个handler。
 *
 * @author Lenovo
 */
@Slf4j
public class NettyServer02Handler extends ChannelInboundHandlerAdapter {
    /**
     * 当有数据传送的时候，这个方法就被触发
     *
     * @param ctx 包含的对象有:handler上下文对象，通道，管道，地址
     * @param msg 客户端发送的数据
     * @throws Exception
     */
    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {
        /**
         * 可以通过异步的方式，来执行定时任务，解决高并发，事件较长的业务
         */
        ctx.channel().eventLoop().execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10 * 1000);
                    log.info("我是定时任务，睡眠了10S---------------------");
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端,我是定时任务，睡眠了10S", CharsetUtil.UTF_8));
                } catch (Exception e) {
                    log.error(e.getMessage());
                }

            }
        });
        log.info("ctx:{}", ctx);
        ByteBuf byteBuf = (ByteBuf) msg;
        log.info("客户端发送的消息是:{}", ((ByteBuf) msg).toString(CharsetUtil.UTF_8));
        log.info("客户端的地址:{}", ctx.channel().remoteAddress());
        ctx.channel().eventLoop().execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(20 * 1000);
                    log.info("我是定时任务，睡眠了20S---------------------");
                    ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端,我是定时任务，睡眠了20S", CharsetUtil.UTF_8));
                } catch (Exception e) {
                    log.error(e.getMessage());
                }

            }
        });
    }

    /**
     * 数据读取完毕
     *
     * @param ctx 上下文对象
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello,客户端", CharsetUtil.UTF_8));
    }

    /**
     * 出现异常的时候关闭通道
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
