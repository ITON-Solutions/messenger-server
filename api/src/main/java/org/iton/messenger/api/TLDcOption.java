package org.iton.messenger.api;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLObject;

import java.io.IOException;

import static org.iton.messenger.core.utils.StreamingUtils.*;

public class TLDcOption extends TLObject {
    public static final int CLASS_ID = 0x2ec2a43c;
    protected int id;
    protected String hostname;
    protected String ip_address;
    protected int port;

    public TLDcOption() {
    }

    public TLDcOption(int id, String hostname, String ip_address, int port) {
        this.id         = id;
        this.hostname   = hostname;
        this.ip_address = ip_address;
        this.port       = port;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHostname() {
        return this.hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIpAddress() {
        return this.ip_address;
    }

    public void setIpAddress(String ip_address) {
        this.ip_address = ip_address;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public void serializeBody(ByteBuf stream)  throws IOException {
        writeInt(this.id, stream);
        writeTLString(this.hostname, stream);
        writeTLString(this.ip_address, stream);
        writeInt(this.port, stream);
    }

    @Override
    public void deserializeBody(ByteBuf stream, TLContext context) throws IOException {
        this.id         = readInt(stream);
        this.hostname   = readTLString(stream);
        this.ip_address = readTLString(stream);
        this.port       = readInt(stream);
    }

    @Override
    public String toString() {
        return "dcOption#2ec2a43c";
    }
}
