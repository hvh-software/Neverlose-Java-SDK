package cn.fluxhvh.neverlose.utils;

import java.util.concurrent.atomic.AtomicLong;

public class PacketIDUtils {
    private final static AtomicLong currentPacketId = new AtomicLong(System.currentTimeMillis() * 10000L);

    public static long generatePacketId() {
        synchronized (currentPacketId) {
            return currentPacketId.incrementAndGet();
        }
    }
}
