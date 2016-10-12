package org.iton.messenger.api;


public class TLRpcAnswerDroppedRunning extends RpcDropAnswer {
    public static final int CLASS_ID = 0xcd78e586;

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public String toString() {
        return "rpc.answerDroppedRunning#cd78e586";
    }
}