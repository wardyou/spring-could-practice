package practice.wyadmin.config;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Component;

/**
 * 过滤器
 *
 * @author
 * @create 2019-05-29 14:34
 */
@Component
public class NettyServerFilter  extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

    }
}
