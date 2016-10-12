package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDecryptedMessageActionResend extends DecryptedMessageAction {
    public static final int CLASS_ID = 0x511110b0;

    public TLDecryptedMessageActionResend() {
    }

    public TLDecryptedMessageActionResend(int start_seq_no, int end_seq_no) {
        this.start_seq_no = start_seq_no;
        this.end_seq_no   = end_seq_no;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }


    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeInt(this.start_seq_no, stream);
        writeInt(this.end_seq_no, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.start_seq_no = readInt(stream);
        this.end_seq_no   = readInt(stream);
    }

    @Override
    public String toString() {
        return "decrypted.message.action.Resend#511110b0";
    }
}