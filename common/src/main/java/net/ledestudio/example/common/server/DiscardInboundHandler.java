package net.ledestudio.example.common.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class DiscardInboundHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Logger.getLogger("Network").info("common Server channelActive");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, @NotNull Object msg) throws Exception {
//        ((ByteBuf) msg).release();
        try {
            //do
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
