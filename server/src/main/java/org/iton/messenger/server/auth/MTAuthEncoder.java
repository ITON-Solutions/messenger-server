package org.iton.messenger.server.auth;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.iton.messenger.proto.util.TimeUtil;
import org.iton.messenger.core.TLObject;

import static org.iton.messenger.core.utils.StreamingUtils.*;

/**
 * Created by ITON on 9/2/14.
 *
 * Encodes an {@link TLObject} into a {@link io.netty.buffer.ByteBuf}.
 * {@link io.netty.handler.codec.MessageToByteEncoder} implementation.
 */
public class MTAuthEncoder extends MessageToByteEncoder<TLObject> {

    private static final InternalLogger log = InternalLoggerFactory.getInstance(MTAuthEncoder.class);

    private static final long EMPTY_AUTH_KEY_ID = 0L;
    private boolean confirm = false;
    private long last_id    = TimeUtil.generateMessageId(true);

    @Override
    protected void encode(ChannelHandlerContext ctx, TLObject object, ByteBuf out) throws Exception {

        byte[] data     = object.serialize();
        long message_id = last_id = TimeUtil.generateMessageId(last_id, true);

        /**
         * Packet length is the result of sum:
         * data length (int value) 4 bytes
         * auth_id (long value) 8 bytes
         * message_id (long value) 8 bytes
         * data value length data.length bytes
         */
        int length = data.length + 0x14;

        if (confirm)
        {
            if (length / 4 >= 0x7F)
            {
                int len =length / 4;
                out.writeByte(0xFF);
                out.writeByte(len & 0xFF);
                out.writeByte((len >> 8) & 0xFF);
                out.writeByte((len >> 16) & 0xFF);
            }
            else
            {
                out.writeByte((length / 4) | (1 << 7));
            }
        }
        else
        {
            if (length / 4 >= 0x7F)
            {
                int len = length / 4;
                out.writeByte(0x7F);
                out.writeByte(len & 0xFF);
                out.writeByte((len >> 8) & 0xFF);
                out.writeByte((len >> 16) & 0xFF);
            }
            else
            {
                out.writeByte(length / 4);
            }
        }

        writeLong(EMPTY_AUTH_KEY_ID, out);
        writeLong(message_id, out);
        writeInt(data.length, out);
        writeBytes(data, out);
    }
}
