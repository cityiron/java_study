package com.funnycode.netty.f07;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.springframework.util.StringUtils;

import java.nio.charset.Charset;

/**
 * @author tc
 * @date 2021/1/23
 */
public class MessageEncoder extends MessageToByteEncoder<Message> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf out) throws Exception {
        // 这里会判断消息类型是不是EMPTY类型，如果是EMPTY类型，则表示当前消息不需要写入到管道中
        if (message.getType() != MessageTypeEnum.EMPTY) {
            out.writeShort(Constants.MAGIC_NUMBER);    // 写入当前的魔数
            out.writeByte(Constants.VERSION);    // 写入当前的版本号
            out.writeByte(Constants.ALGORITHM);    // 写入当前的算法版本
            out.writeByte(message.getType().getType());    // 写入当前的修订版本号
            out.writeByte(message.getStatus().getStatus());
            out.writeInt(0000);    // 写入当前消息的附加参数数量

            if (null == message.getBody()) {
                out.writeInt(0);    // 如果消息体为空，则写入0，表示消息体长度为0
            } else {
                out.writeInt(message.getBody().length());
                out.writeCharSequence(message.getBody(), Charset.defaultCharset());
            }
        }
    }

}
