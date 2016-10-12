package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.readInt;
import static org.iton.messenger.core.utils.StreamingUtils.writeInt;

public class TLDecryptedMessageActionNotifyLayer extends DecryptedMessageAction {
    public static final int CLASS_ID = 0xf3048883;

    public TLDecryptedMessageActionNotifyLayer() {
    }

    public TLDecryptedMessageActionNotifyLayer(int layer) {
        this.layer = layer;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.layer, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.layer = readInt(stream);
    }

    @Override
    public String toString() {
        return "decrypted.message.action.NotifyLayer#f3048883";
    }
}