package com.eMall.util;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomNumUtil {
    private static long id = 0;

    private RandomNumUtil() {
    }

    public static long createId(){
        long id = ThreadLocalRandom.current().nextLong(0,Long.MAX_VALUE);
        return id;
    }
}
