package org.iton.messenger.server.session;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.iton.messenger.server.TLProtoContext;
import org.iton.messenger.server.services.db.DBService;
import org.iton.messenger.api.User;
import org.iton.messenger.model.engines.ITelegramEngine;
import org.iton.messenger.model.entities.ETUser;
import org.iton.messenger.proto.tl.MTMessage;
import org.iton.messenger.proto.tl.TLMessagesAck;
import org.iton.messenger.core.TLContext;
import org.iton.messenger.core.TLLongVector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.iton.messenger.proto.secure.CryptoUtils.ToHex;
import static org.iton.messenger.proto.secure.CryptoUtils.arrayEq;
import static org.iton.messenger.core.utils.StreamingUtils.readInt;

/**
 * Created by ITON on 10/11/14.
 */
public class MTSession {

    private static final InternalLogger log = InternalLoggerFactory.getInstance(MTSession.class);
    private static final ITelegramEngine db = DBService.getInstance().getEngine();

    private long creationTime = System.currentTimeMillis();
    // The last accessed time for this MTSession.
    private long lastAccessTime = creationTime;
    // The current accessed time for this MTSession.
    private long currentAccessTime = creationTime;

    private boolean isNew = true;

    private byte[] authKeyId;
    private byte[] authKey;
    private byte[] serverSalt;
    private byte[] sessionId;

    private ETUser user;

    private final List<Long> confirmedMessages = Collections.synchronizedList(new ArrayList<>());
    private final List<Long> processedMessages = Collections.synchronizedList(new ArrayList<>());

    private long lastMessageId = 0L;
    private int seqNum         = 0;

    private boolean isPushConnection = false;


    public MTSession(byte[] authKeyId, byte[] authKey, byte[] serverSalt, byte[] sessionId, ETUser user) {

        this.authKeyId  = authKeyId;
        this.authKey    = authKey;
        this.serverSalt = serverSalt;
        this.sessionId  = sessionId;
        this.user       = user;
    }

    @Override
    public String toString() {
        return "MTSession [id: 0x" + ToHex(sessionId) + "]";
    }

    public byte[] getAuthKeyId() {
        return authKeyId;
    }

    public byte[] getAuthKey() {
        return authKey;
    }

    public byte[] getServerSalt() {
        return serverSalt;
    }

    public byte[] getSessionId() {
        return sessionId;
    }

    public void setSessionId( byte[] sessionId) {
        this.sessionId = sessionId;
    }

    public User getUser() throws IOException {
        if (user == null) {
            return null;
        }
        TLContext context = new TLProtoContext();
        return (User) context.deserializeMessage(user.getData());
    }

    public void setUser(ETUser user) {
        this.user = user;
    }

    public void setUser(User self) throws IOException {

        user = db.getAuthorizationModel().findById(authKeyId).getUser();
        user.setData(self.serialize());
        db.getUserModel().update(user);
    }

    /**
     * Message to be confirmed. Is a “content-related” message
     * @param messageId
     */
    public void isMessageConfirmed(long messageId) {
        if(confirmedMessages.remove(messageId)) {
            log.debug("Message id: " + messageId + " confirmed by client - (" + confirmedMessages.size() + ") remain to confirm");
        } else {
            log.error("Message id: " + messageId + " not exist in MTSession: " + this.toString());
        }
    }

    /**
     * seqNum:
     * A 32-bit number equal to twice the number of “content-related” messages (those requiring acknowledgment,
     * and in particular those that are not containers) created by the sender prior to this message and
     * subsequently incremented by one if the current message is a content-related message.
     * A container is always generated after its entire contents; therefore,
     * its sequence number is greater than or equal to the sequence numbers of the messages contained in it.
     *
     * @param confirmed is a content-related message, need to be confirmed (not ack, container, etc.)
     * @return
     */
    public synchronized int getSeqNum(boolean confirmed) {
        int value = seqNum;
        if (confirmed) {
            seqNum++;
        }
        return value * 2 + (confirmed ? 1 : 0);
    }

    /**
     * messageId:
     * A (time-dependent) 64-bit number used uniquely to identify a message within a session.
     * Client message identifiers are divisible by 4,
     * server message identifiers modulo 4 yield 1 if the message is a response to a client message,
     * and 3 otherwise.
     * Client message identifiers must increase monotonically (within a single session),
     * the same as server message identifiers, and must approximately equal unixtime*2^32.
     * This way, a message identifier points to the approximate moment in time the message was created.
     * A message is rejected over 300 seconds after it is created or 30 seconds before it is created (this is needed to protect from replay attacks).
     * In this situation, it must be re-sent with a different identifier (or placed in a container with a higher identifier).
     * The identifier of a message container must be strictly greater than those of its nested messages.
     *
     * @param response true if the message is a response to a client message
     * @return
     */
    public synchronized long getMessageId(boolean response) {
        long messageId = (System.currentTimeMillis() / 1000L) << 0x20;

        if (messageId <= lastMessageId) {
            messageId = lastMessageId + 1;
        }

        while (messageId % 4 != (response ? 1 : 3)) {
            messageId++;
        }

        lastMessageId = messageId;
        return messageId;
    }

    public void addMessageToConfirm(long messageId) {
        confirmedMessages.add(messageId);
    }

    public MTMessage getMessagesAck() throws IOException {

        MTMessage message = null;

        if (!processedMessages.isEmpty()) {

            TLLongVector ids = new TLLongVector();
            ids.addAll(processedMessages);
            TLMessagesAck ack = new TLMessagesAck(ids);

            message = new MTMessage(getMessageId(false), getSeqNum(false), ack.serialize());
            processedMessages.clear();
        }

        return message;
    }

    @Override
    public boolean equals(Object session) {
        return session != null && session instanceof MTSession && arrayEq(this.sessionId, ((MTSession) session).getSessionId());
    }

    @Override
    public int hashCode() {
        return readInt(sessionId);
    }

    public long getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(long lastAccessTime) {
        this.isNew = (this.creationTime == this.lastAccessTime);
        this.lastAccessTime = lastAccessTime;
    }

    public long getCurrentAccessTime() {
        return currentAccessTime;
    }

    public void setCurrentAccessTime(long currentAccessTime) {
        this.currentAccessTime = currentAccessTime;
    }

    public boolean isNew() {

        return isNew;
    }

    public boolean isPushConnection() {
        return isPushConnection;
    }

    public void setPushConnection(boolean pushConnection) {
        isPushConnection = pushConnection;
    }
}
