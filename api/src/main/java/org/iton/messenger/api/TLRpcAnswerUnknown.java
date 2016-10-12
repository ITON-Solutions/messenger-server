package org.iton.messenger.api;


public class TLRpcAnswerUnknown extends RpcDropAnswer {
    public static final int CLASS_ID = 0x5e2ad36e;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "rpc.answerUnknown#5e2ad36e";
    }
}