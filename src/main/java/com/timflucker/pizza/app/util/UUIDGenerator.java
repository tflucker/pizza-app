package com.timflucker.pizza.app.util;

import java.util.Random;

public class UUIDGenerator {

	
    public static long get64LeastSignificantBitsForVersion1() {
        final long random63BitLong = new Random().nextLong() & 0x3FFFFFFFFFFFFFFFL;
        long variant3BitFlag = 0x8000000000000000L;
        return random63BitLong | variant3BitFlag;
    }

    public static long get64MostSignificantBitsForVersion1() {
        final long currentTimeMillis = System.currentTimeMillis();
        final long time_low = (currentTimeMillis & 0x0000_0000_FFFF_FFFFL) << 32;
        final long time_mid = ((currentTimeMillis >> 32) & 0xFFFF) << 16;
        final long version = 1 << 12;
        final long time_high = ((currentTimeMillis >> 48) & 0x0FFF);
        return time_low | time_mid | version | time_high;
    }
}
