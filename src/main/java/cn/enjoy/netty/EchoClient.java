package cn.enjoy.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;


/**
 * lzhh
 * createby 2019/7/7 15:11
 * 类说明：
 */


public class EchoClient {
    private final String host;
    private final int port;
    public EchoClient(String host,int port){
        this.host = host;
        this.port = port;
    }

    public void start()throws InterruptedException{
        //EventLoopGroup可以理解为线程租
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {

//启动必须，做一些初始化工作
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)//把线程组传入
                    //指定使用nio进行网络通信
                    .channel(NioSocketChannel.class)
                    /*链接端口ip建立链接*/
                    .remoteAddress(new InetSocketAddress(host,port))
                    //入站处理器
                    .handler(new EchoClientHabdler());
            //链接并且阻塞，直到链接完成
            ChannelFuture f = bootstrap.connect().sync();
            //阻塞直到发生关闭事件
            f.channel().closeFuture().sync();

        }finally {
            eventLoopGroup.shutdownGracefully();
        }

    }
    public static void main(String[] args) throws InterruptedException {
        new EchoClient("127.0.0.1",9999).start();

    }
}
