package org.iton.messenger.core;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.IOException;
import java.io.Serializable;

import static org.iton.messenger.core.utils.StreamingUtils.readInt;
import static org.iton.messenger.core.utils.StreamingUtils.writeInt;

/**
 * Basic class for all tl-objects. Contains methods for serializing and deserializing object.
 * Each tl-object has class id for using in object header for identifying object class for deserialization.
 * This number might be unique and often equals to crc32 of tl-record of tl-constructor.
 * <p/>
 * It is recommended to declare public static final CLASS_ID with tl class id and
 * return this in getClassId and passing it to TLContext.registerClass method during class registration
 */
public abstract class TLObject implements Serializable {

    /**
     * Getting TL Class identification
     *
     * @return id of class
     */
    public abstract int getClassId();

    /**
     * Serializing object to byte array
     *
     * @return serialized object with header
     * @throws java.io.IOException
     */
    public byte[] serialize() throws IOException {
        ByteBuf buf = Unpooled.buffer();
        serialize(buf);
        byte[] array = new byte[buf.readableBytes()];
        buf.getBytes(0, array);
        return array;
    }

    /**
     * Serializing object to stream
     *
     * @param buf destination stream
     * @throws java.io.IOException
     */
    public void serialize(ByteBuf buf) throws IOException {
        writeInt(getClassId(), buf);
        serializeBody(buf);
    }

    /**
     * Deserializing object from ByteBuf and current TLContext
     *
     * @param buf  source ByteBuf
     * @param context tl context
     * @throws java.io.IOException
     * @throws DeserializeException
     */
    public void deserialize(ByteBuf buf, TLContext context) throws IOException {
        int classId = readInt(buf);
        if (classId != getClassId()) {
            throw new DeserializeException("Wrong class id. Founded:" + Integer.toHexString(classId) +
                    ", expected: " + Integer.toHexString(getClassId()));
        }
        deserializeBody(buf, context);
    }

    /**
     * Serializing object body to stream
     *
     * @param buf
     * @throws java.io.IOException
     */
    public void serializeBody(ByteBuf buf) throws IOException {

    }

    /**
     * Deserializing object from ByteBuf and context
     *
     * @param buf
     * @param context tl context
     * @throws DeserializeException
     */
    public void deserializeBody(ByteBuf buf, TLContext context) throws IOException {

    }
}
