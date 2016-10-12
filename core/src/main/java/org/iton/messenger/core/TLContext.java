package org.iton.messenger.core;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.iton.messenger.core.utils.StreamingUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;

/**
 * TypeLanguage context object. It performs deserialization of objects and vectors.
 * All known classes might be registered in context for deserialization.
 * Often this might be performed from inherited class in init() method call.
 * If TL-Object contains static int field CLASS_ID, then it might be used for registration,
 * but it uses reflection so it might be slow in some cases. It recommended to manually pass CLASS_ID
 * to registerClass method.
 *
 */
public abstract class TLContext {

    private final HashMap<Integer, Class> registeredClasses       = new HashMap<Integer, Class>();
    private final HashMap<Integer, Class> registeredCompatClasses = new HashMap<Integer, Class>();

    public TLContext() {
        init();
    }

    protected void init() {

    }

    public boolean isSupportedObject(TLObject object) {
        return isSupportedObject(object.getClassId());
    }

    public boolean isSupportedObject(int classId) {
        return registeredClasses.containsKey(classId);
    }

    public <T extends TLObject> void registerClass(Class<T> tClass) {
        try {
            int classId = tClass.getField("CLASS_ID").getInt(null);
            registeredClasses.put(classId, tClass);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public <T extends TLObject> void registerClass(int clazzId, Class<T> tClass) {
        registeredClasses.put(clazzId, tClass);
    }

    public <T extends TLObject> void registerCompatClass(Class<T> tClass) {
        try {
            int classId = tClass.getField("CLASS_ID").getInt(null);
            registeredCompatClasses.put(classId, tClass);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public <T extends TLObject> void registerCompatClass(int clazzId, Class<T> tClass) {
        registeredCompatClasses.put(clazzId, tClass);
    }

    protected TLObject convertCompatClass(TLObject src) {
        return src;
    }

    public TLObject deserializeMessage(byte[] data) throws IOException {
        ByteBuf src = Unpooled.copiedBuffer(data);
        return deserializeMessage(src);
    }

    public TLObject deserializeMessage(int clazzId, ByteBuf buf) throws IOException{
        if (clazzId == TLGzipObject.CLASS_ID) {
            TLGzipObject obj = new TLGzipObject();
            obj.deserializeBody(buf, this);

            ByteBuf gzip = Unpooled.buffer();
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(obj.getPackedData()));

            byte[] data = new byte[0x200];
            int read = -1;
            try {
                while ((read = gis.read(data)) != -1) {
                    gzip.writeBytes(data, 0, read);
                }
            } catch (EOFException e) {

            }

            int innerClazzId = StreamingUtils.readInt(gzip);
            return deserializeMessage(innerClazzId, gzip);
        }

        if (clazzId == TLBoolTrue.CLASS_ID) {
            return new TLBoolTrue();
        }

        if (clazzId == TLBoolFalse.CLASS_ID) {
            return new TLBoolFalse();
        }

        if (registeredCompatClasses.containsKey(clazzId)) {
            try {
                Class messageClass = registeredCompatClasses.get(clazzId);
                TLObject message = (TLObject) messageClass.getConstructor().newInstance();
                message.deserializeBody(buf, this);
                return convertCompatClass(message);
            } catch (DeserializeException e) {
                throw e;
            } catch (IllegalAccessException | IllegalArgumentException | IOException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                e.printStackTrace();
                throw new IOException("Unable to deserialize data");
            }
        }

        try {
            Class messageClass = registeredClasses.get(clazzId);
            if (messageClass != null) {
                TLObject message = (TLObject) messageClass.getConstructor().newInstance();
                message.deserializeBody(buf, this);
                return message;
            } else {
                throw new DeserializeException("Unsupported class: #" + Integer.toHexString(clazzId));
            }
        } catch (DeserializeException e) {
            throw e;
        } catch (IllegalAccessException | IllegalArgumentException | IOException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            e.printStackTrace();
            throw new IOException("Unable to deserialize data");
        }
    }

    public TLObject deserializeMessage(ByteBuf buf) throws IOException {
        int clazzId = StreamingUtils.readInt(buf);
        return deserializeMessage(clazzId, buf);
    }

    public TLVector deserializeVector(ByteBuf buf) throws IOException {
        int clazzId = StreamingUtils.readInt(buf);
        if (clazzId == TLVector.CLASS_ID) {
            TLVector res = new TLVector();
            res.deserializeBody(buf, this);
            return res;
        } else if (clazzId == TLGzipObject.CLASS_ID) {
            TLGzipObject obj = new TLGzipObject();
            obj.deserializeBody(buf, this);
            ByteBuf gzipByteBuffer = Unpooled.buffer(obj.getPackedData().length);
            gzipByteBuffer.writeBytes(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(obj.getPackedData()))), obj.getPackedData().length);
            return deserializeVector(gzipByteBuffer);
        } else {
            throw new IOException("Unable to deserialize vector");
        }
    }

    public TLIntVector deserializeIntVector(ByteBuf buf) throws IOException {
        int clazzId = StreamingUtils.readInt(buf);
        if (clazzId == TLVector.CLASS_ID) {
            TLIntVector res = new TLIntVector();
            res.deserializeBody(buf, this);
            return res;
        } else if (clazzId == TLGzipObject.CLASS_ID) {
            TLGzipObject obj = new TLGzipObject();
            obj.deserializeBody(buf, this);
            ByteBuf gzipByteBuffer = Unpooled.buffer(obj.getPackedData().length);
            gzipByteBuffer.writeBytes(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(obj.getPackedData()))), obj.getPackedData().length);
            return deserializeIntVector(gzipByteBuffer);
        } else {
            throw new IOException("Unable to deserialize vector");
        }
    }

    public TLLongVector deserializeLongVector(ByteBuf buf) throws IOException {
        int clazzId = StreamingUtils.readInt(buf);
        if (clazzId == TLVector.CLASS_ID) {
            TLLongVector res = new TLLongVector();
            res.deserializeBody(buf, this);
            return res;
        } else if (clazzId == TLGzipObject.CLASS_ID) {
            TLGzipObject obj = new TLGzipObject();
            obj.deserializeBody(buf, this);
            ByteBuf gzipByteBuffer = Unpooled.buffer(obj.getPackedData().length);
            gzipByteBuffer.writeBytes(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(obj.getPackedData()))), obj.getPackedData().length);
            return deserializeLongVector(gzipByteBuffer);
        } else {
            throw new IOException("Unable to deserialize vector");
        }
    }

    public TLStringVector deserializeStringVector(ByteBuf buf) throws IOException {
        int clazzId = StreamingUtils.readInt(buf);
        if (clazzId == TLVector.CLASS_ID) {
            TLStringVector res = new TLStringVector();
            res.deserializeBody(buf, this);
            return res;
        } else if (clazzId == TLGzipObject.CLASS_ID) {
            TLGzipObject obj = new TLGzipObject();
            obj.deserializeBody(buf, this);
            ByteBuf gzipByteBuffer = Unpooled.buffer(obj.getPackedData().length);
            gzipByteBuffer.writeBytes(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(obj.getPackedData()))), obj.getPackedData().length);
            return deserializeStringVector(gzipByteBuffer);
        } else {
            throw new IOException("Unable to deserialize vector");
        }
    }

    public TLBytes allocateBytes(int size) {
        return new TLBytes(new byte[size], 0, size);
    }

    public void releaseBytes(TLBytes unused) {

    }
}
