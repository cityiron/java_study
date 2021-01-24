package com.funnycode.netty.f07;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @author tc
 * @date 2021/1/23
 */
public class CustomerProtocol {
    /*
    +---------------------------------------------------------------+
    | 魔数 2byte | 协议版本号 1byte | 序列化算法 1byte | 报文类型 1byte  |
    +---------------------------------------------------------------+
    | 状态 1byte |        保留字段 4byte     |      数据长度 4byte     |
    +---------------------------------------------------------------+
    |                   数据内容 （长度不定）                          |
    +---------------------------------------------------------------+
     */
    public static void main(String[] args) {
        int port = 8899;
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup work = new NioEventLoopGroup();

        try {
            serverBootstrap.group(boss, work)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) {
                        ch.pipeline()
                            .addLast(new MessageToByteEncoder() {
                                @Override
                                protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out)
                                    throws Exception {

                                }
                            })
                            .addLast(new MessageToMessageEncoder<ByteBuf>() {
                                @Override
                                protected void encode(ChannelHandlerContext ctx, ByteBuf in, List out)
                                    throws Exception {
                                    // 判断 ByteBuf 可读取字节
                                    if (in.readableBytes() < 14) {
                                        return;
                                    }
                                    in.markReaderIndex(); // 标记 ByteBuf 读指针位置
                                    in.skipBytes(2); // 跳过魔数
                                    in.skipBytes(1); // 跳过协议版本号
                                    byte serializeType = in.readByte();
                                    in.skipBytes(1); // 跳过报文类型
                                    in.skipBytes(1); // 跳过状态字段
                                    in.skipBytes(4); // 跳过保留字段
                                    int dataLength = in.readInt();
                                    if (in.readableBytes() < dataLength) {
                                        in.resetReaderIndex(); // 重置 ByteBuf 读指针位置
                                        return;
                                    }
                                    byte[] data = new byte[dataLength];
                                    in.readBytes(data);
                                    SerializeService serializeService = getSerializeServiceByType(serializeType);
                                    Object obj = serializeService.deserialize(data);
                                    if (obj != null) {
                                        out.add(obj);
                                    }
                                }
                            });
                    }
                });
            ChannelFuture f = serverBootstrap.bind().sync();
            System.out.println("Http Server started， Listening on " + port);
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            work.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }

}
