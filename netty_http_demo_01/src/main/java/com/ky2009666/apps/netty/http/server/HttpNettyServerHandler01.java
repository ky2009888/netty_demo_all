package com.ky2009666.apps.netty.http.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * http netty server的案例演示
 *
 * @author Lenovo
 */
@Slf4j
public class HttpNettyServerHandler01 extends SimpleChannelInboundHandler<HttpObject> {

    /**
     * Is called for each message of type {@link I}.
     *
     * @param ctx the {@link ChannelHandlerContext} which this {@link SimpleChannelInboundHandler}
     *            belongs to
     * @param msg the message to handle
     * @throws Exception is thrown if an error occurred
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof HttpRequest) {
            log.info("msgl类型:{}", msg.getClass());
            log.info("客户端的地址：{}", ctx.channel().remoteAddress());
            //回复客户端信息:
            ByteBuf byteBuf = Unpooled.copiedBuffer("hello,我是服务器", CharsetUtil.UTF_8);
            //构造一个http响应
            FullHttpResponse response
                    = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, byteBuf);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=utf-8");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH,byteBuf.readableBytes());
            ctx.writeAndFlush(response);

        }
    }
}
