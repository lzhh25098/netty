package cn.enjoy.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.buffer.UnpooledHeapByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;


/**
 * lzhh
 * createby 2019/7/7 16:09
 * 类说明：
 */


public class EchoClientHabdler extends SimpleChannelInboundHandler<ByteBuf> {
    /*链接建立以后*/
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //向对端发送消息
        ctx.writeAndFlush(Unpooled.copiedBuffer("---------hello Netty---------"
                , CharsetUtil.UTF_8));
    }

    /*发生异常以后怎么处理*/
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //打印异常
       cause.printStackTrace();
       //关闭链接
       ctx.close();
    }

    /*当前客户端读到数据执行*/
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf)
            throws Exception {
        //打印数据
        System.out.println("client  acccept:" + byteBuf.toString(CharsetUtil.UTF_8));

    }

}
