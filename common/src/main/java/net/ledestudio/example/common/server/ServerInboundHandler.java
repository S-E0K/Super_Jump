package net.ledestudio.example.common.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import net.ledestudio.example.common.data.User;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class ServerInboundHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Logger.getLogger("Network").info("Channel Active");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, @NotNull Object msg) throws Exception {
//        ((ByteBuf) msg).release();
        try {
            ByteBuf buf = (ByteBuf) msg;
            final int id = buf.readInt();
            if (id == 1) {
                User user = new User(buf);
                Logger.getLogger("NetWork").info(user.toString());
            }

        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
