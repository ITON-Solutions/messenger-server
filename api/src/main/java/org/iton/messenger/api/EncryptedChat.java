package org.iton.messenger.api;

import org.iton.messenger.core.TLObject;

public abstract class EncryptedChat extends TLObject {
    protected int id;
    protected long access_hash;
    protected int date;
    protected int admin_id;
    protected int participant_id;
    protected byte[] g_a_or_b;
    protected long key_fingerprint;
    protected byte[] g_a;
    protected byte[] a_or_b;
    protected byte[] auth_key;
    protected int user_id;
    protected int ttl;
    protected int layer;
    protected int seq_in;
    protected int seq_out;
    protected byte[] key_hash;
    protected short key_use_count_in;
    protected short key_use_count_out;
    protected long exchange_id;
    protected int key_create_date;
    protected long future_key_fingerprint;
    protected byte[] future_auth_key;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAccessHash() {
        return access_hash;
    }

    public void setAccessHash(long access_hash) {
        this.access_hash = access_hash;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getAdminId() {
        return admin_id;
    }

    public void setAdminId(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getParticipantId() {
        return participant_id;
    }

    public void setParticipantId(int participant_id) {
        this.participant_id = participant_id;
    }

    public byte[] getG_a_Or_b() {
        return g_a_or_b;
    }

    public void setG_a_Or_b(byte[] g_a_or_b) {
        this.g_a_or_b = g_a_or_b;
    }

    public long getKeyGingerprint() {
        return key_fingerprint;
    }

    public void setKeyFingerprint(long key_fingerprint) {
        this.key_fingerprint = key_fingerprint;
    }

    public byte[] getG_a() {
        return g_a;
    }

    public void setG_a(byte[] g_a) {
        this.g_a = g_a;
    }

    public byte[] getA_Or_b() {
        return a_or_b;
    }

    public void setA_Or_b(byte[] a_or_b) {
        this.a_or_b = a_or_b;
    }

    public byte[] getAuthKey() {
        return auth_key;
    }

    public void setAuthKey(byte[] auth_key) {
        this.auth_key = auth_key;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getTTL() {
        return ttl;
    }

    public void setTTL(int ttl) {
        this.ttl = ttl;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getSeqIn() {
        return seq_in;
    }

    public void setSeqIn(int seq_in) {
        this.seq_in = seq_in;
    }

    public int getSeqOut() {
        return seq_out;
    }

    public void setSeqOut(int seq_out) {
        this.seq_out = seq_out;
    }

    public byte[] getKeyHash() {
        return key_hash;
    }

    public void setKeyHash(byte[] key_hash) {
        this.key_hash = key_hash;
    }

    public short getKeyUseCountIn() {
        return key_use_count_in;
    }

    public void setKeyUseCountIn(short key_use_count_in) {
        this.key_use_count_in = key_use_count_in;
    }

    public short getKeyUseCountOut() {
        return key_use_count_out;
    }

    public void setKeyUseCountOut(short key_use_count_out) {
        this.key_use_count_out = key_use_count_out;
    }

    public long getExchangeId() {
        return exchange_id;
    }

    public void setExchangeId(long exchange_id) {
        this.exchange_id = exchange_id;
    }

    public int getKeyCreateDate() {
        return key_create_date;
    }

    public void setKeyCreateDate(int key_create_date) {
        this.key_create_date = key_create_date;
    }

    public long getFutureKeyFingerprint() {
        return future_key_fingerprint;
    }

    public void setFutureKeyFingerprint(long future_key_fingerprint) {
        this.future_key_fingerprint = future_key_fingerprint;
    }

    public byte[] getFutureAuthKey() {
        return future_auth_key;
    }

    public void setFutureAuthKey(byte[] future_auth_key) {
        this.future_auth_key = future_auth_key;
    }
}
