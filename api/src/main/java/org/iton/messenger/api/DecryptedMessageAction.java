package org.iton.messenger.api;

import org.iton.messenger.core.TLLongVector;
import org.iton.messenger.core.TLObject;

public abstract class DecryptedMessageAction extends TLObject
{
    protected int start_seq_no;
    protected int end_seq_no;
    protected int ttl_seconds;
    protected int layer;
    protected TLLongVector random_ids = new TLLongVector();
    protected long exchange_id;
    protected long key_fingerprint;
    protected byte[] g_b;
    protected SendMessageAction action;
    protected byte[] g_a;

    public int getStartSeqNo() {
        return start_seq_no;
    }

    public void setStartSeqNo(int start_seq_no) {
        this.start_seq_no = start_seq_no;
    }

    public int getEndSeqNo() {
        return end_seq_no;
    }

    public void setEndSeqNo(int end_seq_no) {
        this.end_seq_no = end_seq_no;
    }

    public int getTTLSeconds() {
        return ttl_seconds;
    }

    public void setTTTLSeconds(int ttl_seconds) {
        this.ttl_seconds = ttl_seconds;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public TLLongVector getRandomIds() {
        return random_ids;
    }

    public void setRandomIds(TLLongVector random_ids) {
        this.random_ids = random_ids;
    }

    public long getExchangeId() {
        return exchange_id;
    }

    public void setExchangeId(long exchange_id) {
        this.exchange_id = exchange_id;
    }

    public long getKeyFingerprint() {
        return key_fingerprint;
    }

    public void setKeyFingerprint(long key_fingerprint) {
        this.key_fingerprint = key_fingerprint;
    }

    public byte[] getG_b() {
        return g_b;
    }

    public void setG_b(byte[] g_b) {
        this.g_b = g_b;
    }

    public SendMessageAction getAction() {
        return action;
    }

    public void setAction(SendMessageAction action) {
        this.action = action;
    }

    public byte[] getG_a() {
        return g_a;
    }

    public void setG_a(byte[] g_a) {
        this.g_a = g_a;
    }
}
