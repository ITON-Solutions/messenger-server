package org.iton.messenger.core.utils;

import io.netty.buffer.ByteBuf;
import org.iton.messenger.core.*;

import java.io.IOException;

/**
 * Helper class for writing and reading data for tl (de-)serialization.
 *
 */
public class StreamingUtils {

    /**
     * Writing byte to stream
     *
     * @param v      value
     * @param buf destination stream
     */
    public static void writeByte(int v, ByteBuf buf) throws IOException {
        buf.writeByte(v);
    }

    /**
     * Writing byte to ByteBuf
     *
     * @param v      value
     * @param buf destination ByteBuf
     * @throws java.io.IOException
     */
    public static void writeByte(byte v, ByteBuf buf) throws IOException {
        buf.writeByte(v);
    }

    /**
     * Writing int to ByteBuf
     *
     * @param v      value
     * @param buf destination ByteBuf
     * @throws java.io.IOException
     */
    public static void writeInt(int v, ByteBuf buf) throws IOException {
        writeByte((byte) (v & 0xFF), buf);
        writeByte((byte) ((v >> 8) & 0xFF), buf);
        writeByte((byte) ((v >> 16) & 0xFF), buf);
        writeByte((byte) ((v >> 24) & 0xFF), buf);
    }

    /**
     * Writing long to ByteBuf
     *
     * @param v      value
     * @param buf destination ByteBuf
     */
    public static void writeLong(long v, ByteBuf buf) throws IOException {
        writeByte((byte) (v & 0xFF), buf);
        writeByte((byte) ((v >> 8) & 0xFF), buf);
        writeByte((byte) ((v >> 16) & 0xFF), buf);
        writeByte((byte) ((v >> 24) & 0xFF), buf);

        writeByte((byte) ((v >> 32) & 0xFF), buf);
        writeByte((byte) ((v >> 40) & 0xFF), buf);
        writeByte((byte) ((v >> 48) & 0xFF), buf);
        writeByte((byte) ((v >> 56) & 0xFF), buf);
    }

    /**
     * Writing double to ByteBuf
     *
     * @param v      value
     * @param buf destination ByteBuf
     * @throws java.io.IOException
     */
    public static void writeDouble(double v, ByteBuf buf) throws IOException {
        writeLong(Double.doubleToLongBits(v), buf);
    }

    /**
     * Writing byte array to ByteBuf
     *
     * @param data   data
     * @param buf destination ByteBuf
     * @throws java.io.IOException
     */
    public static void writeBytes(byte[] data, ByteBuf buf) throws IOException {
        buf.writeBytes(data);
    }

    /**
     * Writing byte array to ByteBuf
     *
     * @param data   data
     * @param offset
     * @param len
     * @param buf destination ByteBuf
     * @throws java.io.IOException
     */
    public static void writeBytes(byte[] data, int offset, int len, ByteBuf buf) throws IOException {
        buf.writeBytes(data, offset, len);
    }

    /**
     * Writing tl-bool value
     *
     * @param v      value
     * @param buf destination ByteBuf
     * @throws java.io.IOException
     */
    public static void writeTLBool(boolean v, ByteBuf buf) throws IOException {
        if (v) {
            writeInt(TLBoolTrue.CLASS_ID, buf);
        } else {
            writeInt(TLBoolFalse.CLASS_ID, buf);
        }
    }

    /**
     * Writing tl-string value
     *
     * @param v      value
     * @param buf destination ByteBuf
     * @throws java.io.IOException
     */
    public static void writeTLString(String v, ByteBuf buf) throws IOException {
        writeTLBytes(v.getBytes(), buf);
    }

    /**
     * Writing tl-bytes value
     *
     * @param data      value
     * @param buf destination ByteBuf
     * @throws java.io.IOException
     */
    public static void writeTLBytes(byte[] data, ByteBuf buf) throws IOException {
        int startOffset = 1;
        if (data.length >= 254) {
            startOffset = 4;
            writeByte(254, buf);
            writeByte(data.length & 0xFF, buf);
            writeByte((data.length >> 8) & 0xFF, buf);
            writeByte((data.length >> 16) & 0xFF, buf);
        } else {
            writeByte(data.length, buf);
        }

        writeBytes(data, buf);

        int offset = (data.length + startOffset) % 4;
        if (offset != 0) {
            int offsetCount = 4 - offset;
            writeBytes(new byte[offsetCount], buf);
        }
    }

    /**
     * Writing tl-bytes value
     *
     * @param v      value
     * @param buf destination ByteBuf
     * @throws java.io.IOException
     */
    public static void writeTLBytes(TLBytes v, ByteBuf buf) throws IOException {
        int startOffset = 1;
        if (v.getLength() >= 254) {
            startOffset = 4;
            writeByte(254, buf);
            writeByte(v.getLength() & 0xFF, buf);
            writeByte((v.getLength() >> 8) & 0xFF, buf);
            writeByte((v.getLength() >> 16) & 0xFF, buf);
        } else {
            writeByte(v.getLength(), buf);
        }

        writeBytes(v.getData(), v.getOffset(), v.getLength(), buf);

        int offset = (v.getLength() + startOffset) % 4;
        if (offset != 0) {
            int offsetCount = 4 - offset;
            writeBytes(new byte[offsetCount], buf);
        }
    }

    /**
     * Writing tl-object to ByteBuf
     *
     * @param obj      tl-object
     * @param buf destination ByteBuf
     * @throws java.io.IOException
     */
    public static void writeTLObject(TLObject obj, ByteBuf buf) throws IOException {
        obj.serialize(buf);
    }

    /**
     * Writing tl-method to ByteBuf. Same as writeTLObject, but used for pretty code
     *
     * @param v      tl-method
     * @param buf destination ByteBuf
     * @throws java.io.IOException
     */
    public static void writeTLMethod(TLMethod v, ByteBuf buf) throws IOException {
        writeTLObject(v, buf);
    }

    /**
     * Writing tl-vector to ByteBuf
     *
     * @param vector      tl-vector
     * @param buf destination ByteBuf
     * @throws java.io.IOException
     */
    public static void writeTLVector(TLVector vector, ByteBuf buf) throws IOException {
        writeTLObject(vector, buf);
    }

    /**
     * Reading int from ByteBuf
     *
     * @param buf source ByteBuf
     * @return value
     * @throws java.io.IOException reading exception
     */
    public static int readInt(ByteBuf buf) throws IOException {
        
        return buf.readIntLE();
    }

    /**
     * Reading uint from ByteBuf
     *
     * @param buf source ByteBuf
     * @return value
     * @throws java.io.IOException reading exception
     */
    public static long readUInt(ByteBuf buf) throws IOException {
        
        return buf.readUnsignedIntLE();
    }

    /**
     * Reading long from ByteBuf
     *
     * @param buf source ByteBuf
     * @return value
     * @throws java.io.IOException reading exception
     */
    public static long readLong(ByteBuf buf) throws IOException {
        long a = readUInt(buf);
        long b = readUInt(buf);

        return a + (b << 32);
    }

    /**
     * Reading double from ByteBuf
     *
     * @param buf source ByteBuf
     * @return value
     * @throws java.io.IOException reading exception
     */
    public static double readDouble(ByteBuf buf) throws IOException {
        return Double.longBitsToDouble(readLong(buf));
    }

    /**
     * Reading tl-string from ByteBuf
     *
     * @param buf source ByteBuf
     * @return value
     * @throws java.io.IOException
     */
    public static String readTLString(ByteBuf buf) throws IOException {
        return new String(readTLBytes(buf));
    }

    /**
     * Reading tl-object from ByteBuf
     *
     * @param buf  source ByteBuf
     * @param context tl-context
     * @return tl-object
     * @throws java.io.IOException reading exception
     * @throws java.io.IOException
     */
    public static TLObject readTLObject(ByteBuf buf, TLContext context) throws IOException, IOException {
        return context.deserializeMessage(buf);
    }

    /**
     * Reading tl-method from ByteBuf. Same as readTLObject, used for pretty code.
     *
     * @param buf  source ByteBuf
     * @param context tl-method
     * @return tl-method
     * @throws java.io.IOException reading exception
     * @throws java.io.IOException
     */
    public static TLMethod readTLMethod(ByteBuf buf, TLContext context) throws IOException, IOException {
        return (TLMethod) context.deserializeMessage(buf);
    }

    /**
     * Reading bytes from ByteBuf
     *
     * @param count  bytes count
     * @param buf
     * @return readed bytes
     * @throws java.io.IOException reading exception
     */
    public static byte[] readBytes(int count, ByteBuf buf) throws IOException {
        byte[] res = new byte[count];
        buf.readBytes(res);
        return res;
    }

    /**
     * Reading bytes from ByteBufByteBuf
     *
     * @param count  bytes count
     * @param buf source ByteBuf
     * @throws java.io.IOException
     */
    public static void skipBytes(int count, ByteBuf buf) throws IOException {
        buf.skipBytes(count);
    }

    /**
     * Reading bytes from ByteBuf
     *
     * @param buffer
     * @param offset
     * @param count  bytes count
     * @param buf source ByteBuf
     * @return 
     * @throws java.io.IOException
     */
    public static ByteBuf readBytes(byte[] buffer, int offset, int count, ByteBuf buf) throws IOException {
       return buf.readBytes(buffer, offset, count);
        
    }


    public static int readUByte(ByteBuf buf) {
        int mask = buf.readByte() & 0xFF ;
        return (mask  < 0 ? 128 + mask : mask);
    }

    /**
     * Reading unsigned byte from ByteBuf
     *
     * @param buf source ByteBuf
     * @return readed unsigned byte
     * @throws java.io.IOException
     */
    public static byte[] readTLBytes(ByteBuf buf) throws IOException {

        int count = readUByte(buf);
        int startOffset = 1;
        if (count >= 254) {
            count = readUByte(buf) + (readUByte(buf) << 0x8) + (readUByte(buf) << 0x10);
            startOffset = 4;
        }

        byte[] raw = readBytes(count, buf);
        int offset = (count + startOffset) % 4;
        if (offset != 0) {
            int offsetCount = 4 - offset;
            skipBytes(offsetCount, buf);
        }

        return raw;
    }

    /**
     * Reading tl-bytes from ByteBuf with manual allocation
     *
     * @param buf  source ByteBuf
     * @param context tl-context
     * @return readed bytes
     * @throws java.io.IOException
     */
    public static TLBytes readTLBytes(ByteBuf buf, TLContext context) throws IOException {
        int count = readUByte(buf);
        int startOffset = 1;
        if (count >= 254) {
            count = readUByte(buf) + (readUByte(buf) << 0x8) + (readUByte(buf) << 0x10);
            startOffset = 4;
        }
        TLBytes res = context.allocateBytes(count);
        readBytes(res.getData(), res.getOffset(), res.getLength(), buf);

        int offset = (count + startOffset) % 4;
        if (offset != 0) {
            int offsetCount = 4 - offset;
            skipBytes(offsetCount, buf);
        }
        return res;
    }

    /**
     * Reading tl-vector from ByteBuf
     *
     * @param buf  source ByteBuf
     * @param context tl-context
     * @return tl-vector
     * @throws java.io.IOException reading exception
     * @throws java.io.IOException
     */
    public static TLVector readTLVector(ByteBuf buf, TLContext context) throws IOException, IOException {
        return context.deserializeVector(buf);
    }

    /**
     * Reading tl-vector of integers from ByteBuf
     *
     * @param buf  source ByteBuf
     * @param context tl-context
     * @return tl-vector of integers
     * @throws java.io.IOException reading exception
     */
    public static TLIntVector readTLIntVector(ByteBuf buf, TLContext context) throws IOException, IOException {
        return context.deserializeIntVector(buf);
    }

    /**
     * Reading tl-vector of longs from ByteBuf
     *
     * @param buf  source ByteBuf
     * @param context tl-context
     * @return tl-vector of longs
     * @throws java.io.IOException reading exception
     */
    public static TLLongVector readTLLongVector(ByteBuf buf, TLContext context) throws IOException, IOException {
        return context.deserializeLongVector(buf);
    }
    /**
     * Reading tl-vector of strings from ByteBuf
     *
     * @param buf  source ByteBuf
     * @param context tl-context
     * @return tl-vector of strings
     * @throws java.io.IOException reading exception
     * @throws java.io.IOException
     */
    public static TLStringVector readTLStringVector(ByteBuf buf, TLContext context) throws IOException, IOException {
        return context.deserializeStringVector(buf);
    }

    /**
     * Reading tl-bool from ByteBuf
     *
     * @param stream source ByteBuf
     * @return bool
     * @throws java.io.IOException reading exception
     * @throws DeserializeException
     */
    public static boolean readTLBool(ByteBuf stream) throws IOException, DeserializeException {
        int v = readInt(stream);
        if (v == TLBoolTrue.CLASS_ID) {
            return true;
        } else if (v == TLBoolFalse.CLASS_ID) {
            return false;
        } else
            throw new DeserializeException("Not bool value: " + Integer.toHexString(v));
    }

    /**
     * Converting int to bytes
     *
     * @param value source integer
     * @return bytes of integer
     */
    public static byte[] intToBytes(int value) {
        return new byte[]{
                (byte) (value & 0xFF),
                (byte) ((value >> 8) & 0xFF),
                (byte) ((value >> 16) & 0xFF),
                (byte) ((value >> 24) & 0xFF)};
    }

    /**
     * Converting long to bytes
     *
     * @param value source long
     * @return bytes of long
     */
    public static byte[] longToBytes(long value) {
        return new byte[]{
                (byte) (value & 0xFF),
                (byte) ((value >> 8) & 0xFF),
                (byte) ((value >> 16) & 0xFF),
                (byte) ((value >> 24) & 0xFF),
                (byte) ((value >> 32) & 0xFF),
                (byte) ((value >> 40) & 0xFF),
                (byte) ((value >> 48) & 0xFF),
                (byte) ((value >> 56) & 0xFF)};
    }

    /**
     * Reading int from bytes array
     *
     * @param src source bytes
     * @return int value
     */
    public static int readInt(byte[] src) {
        return readInt(src, 0);
    }

    /**
     * Reading int from bytes array
     *
     * @param src    source bytes
     * @param offset offset in array
     * @return int value
     */
    public static int readInt(byte[] src, int offset) {
        int a = src[offset + 0] & 0xFF;
        int b = src[offset + 1] & 0xFF;
        int c = src[offset + 2] & 0xFF;
        int d = src[offset + 3] & 0xFF;

        return a + (b << 8) + (c << 16) + (d << 24);
    }

    /**
     * Reading uint from bytes array
     *
     * @param src source bytes
     * @return uint value
     */
    public static long readUInt(byte[] src) {
        return readUInt(src, 0);
    }

    /**
     * Reading uint from bytes array
     *
     * @param src    source bytes
     * @param offset offset in array
     * @return uint value
     */
    public static long readUInt(byte[] src, int offset) {
        long a = src[offset + 0] & 0xFF;
        long b = src[offset + 1] & 0xFF;
        long c = src[offset + 2] & 0xFF;
        long d = src[offset + 3] & 0xFF;

        return a + (b << 8) + (c << 16) + (d << 24);
    }

    /**
     * Reading long value from bytes array
     *
     * @param src    source bytes
     * @return long value
     */
    public static long readLong(byte[] src) {
       return readLong(src, 0);
    }

    /**
     * Reading long value from bytes array
     *
     * @param src    source bytes
     * @param offset offset in array
     * @return long value
     */
    public static long readLong(byte[] src, int offset) {
        long a = readUInt(src, offset);
        long b = readUInt(src, offset + 4);

        return (a & 0xFFFFFFFF) + ((b & 0xFFFFFFFF) << 32);
    }
}
