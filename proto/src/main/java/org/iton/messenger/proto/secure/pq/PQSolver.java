package org.iton.messenger.proto.secure.pq;

import java.math.BigInteger;


public class PQSolver {
    private static IPQ currentImplementation = new PQLopatin();

    public static void setCurrentImplementation(IPQ implementation) {
        currentImplementation = implementation;
    }

    public static BigInteger solvePq(BigInteger src) {
        return new BigInteger("" + currentImplementation.findDivider(src.longValue()));
    }

    private PQSolver() {

    }
}
