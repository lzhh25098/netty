package cn.enjoy.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;


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
//启动必须，做一些初始化工作
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                //指定使用nio进行网络通信
                .channel(NioSocketChannel.class);//把线程组传入

        

        
    }
    public static void main(String[] args) throws InterruptedException {
        new EchoClient("127.0.0.1",9999).start();

    }
}
