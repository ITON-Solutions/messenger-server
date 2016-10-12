package org.iton.messenger.proto.tl;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;


public class MTNewSessionCreated extends TLObject {

    public static final int CLASS_ID = 0x9ec20908;

    private long firstMsgId;
    private byte[] uniqId;
    private byte[] serverSalt;

    public MTNewSessionCreated(long firstMsgId, byte[] uniqId, byte[] serverSalt) {
        this.firstMsgId = firstMsgId;
        this.uniqId     = uniqId;
        this.serverSalt = serverSalt;
    }

    public MTNewSessionCreated() {}

    public long getFirstMsgId() {
        return firstMsgId;
    }

    public byte[] getUniqId() {
        return uniqId;
    }

    public byte[] getServerSalt() {
        return serverSalt;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void serializeBody(ByteBuf stream) throws IOException {
        writeLong(firstMsgId, stream);
        writeBytes(uniqId, stream);
        writeBytes(serverSalt, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        firstMsgId = readLong(stream);
        uniqId     = readBytes(0x8, stream);
        serverSalt = readBytes(0x8, stream);
    }

    @Override
    public String toString() {
        return "new_session_created#9ec20908";
    }
}
