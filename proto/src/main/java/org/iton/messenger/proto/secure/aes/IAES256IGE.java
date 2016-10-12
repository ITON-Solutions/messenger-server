package org.iton.messenger.proto.secure.aes;

import java.io.IOException;

public abstract interface IAES256IGE {
    public void AES256IGEDecrypt(byte[] src, byte[] dest, int len, byte[] iv, byte[] key);

    public void AES256IGEEncrypt(byte[] src, byte[] dest, int len, byte[] iv, byte[] key);

    public void AES256IGEEncrypt(String sourceFile, String destFile, byte[] iv, byte[] key) throws IOException;

    public void AES256IGEDecrypt(String sourceFile, String destFile, byte[] iv, byte[] key) throws IOException;
}
