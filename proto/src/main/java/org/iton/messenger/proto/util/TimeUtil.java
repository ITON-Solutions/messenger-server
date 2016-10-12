package org.iton.messenger.proto.util;


import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class TimeUtil {
    public static synchronized long generateMessageId(boolean response) {

        long messageId = (System.currentTimeMillis() / 1000L) << 0x20;

        while (messageId % 4 != (response ? 1 : 3)) {
            messageId++;
        }

        return messageId;
    }

    public static synchronized long generateMessageId(long last_id, boolean response) {

        long messageId = (System.currentTimeMillis() / 1000L) << 0x20;

        if (messageId <= last_id) {
            messageId = last_id + 1;
        }

        while (messageId % 4 != (response ? 1 : 3)) {
            messageId++;
        }

        return messageId;
    }

    public static synchronized long getMilliseconds(long messageId) {
        return (messageId >> 0x20) * 1000L;
    }

    public static synchronized String getTime(long messageId) {
        Date date = new Date((messageId >> 0x20) * 1000L);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
        return formatter.format(date);
    }

    public static synchronized int getCurrentTime() {
        return (int)(System.currentTimeMillis() / 1000L);
    }
}