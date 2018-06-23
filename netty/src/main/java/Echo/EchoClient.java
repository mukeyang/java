package Echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

/**
 * Created by CS on 2018/6/23.
 */
public class EchoClient {
    static final boolean SSL = System.getProperty("ssl") != null;
    static final String HOST = System.getProperty("port", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "8081"));
    static final int SIZE = Integer.parseInt(System.getProperty("SIZE", "256"));

    public static void main(String[] args) throws Exception {
        final SslContext sslCtx;
        if (SSL)
            sslCtx = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        else sslCtx = null;
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .remoteAddress(HOST, PORT)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            if (sslCtx != null) pipeline.addLast(sslCtx.newHandler(socketChannel.alloc(), HOST, PORT));
//                            pipeline.addLast(new )

                        }
                    });
        } finally {

        }
    }
}
