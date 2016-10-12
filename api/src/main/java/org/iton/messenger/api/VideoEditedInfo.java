package org.iton.messenger.api;

import java.util.Locale;

/**
 * Created by ITON Solutions on 8/12/16.
 */
public class VideoEditedInfo {

    private long startTime;
    private long endTime;
    private int rotationValue;
    private int originalWidth;
    private int originalHeight;
    private int resultWidth;
    private int resultHeight;
    private int bitrate;
    private String originalPath;

    public String getString() {
        return String.format(Locale.US, "-1_%d_%d_%d_%d_%d_%d_%d_%d_%s", startTime, endTime, rotationValue, originalWidth, originalHeight, bitrate, resultWidth, resultHeight, originalPath);
    }

    public void parseString(String string) {
        if (string.length() < 6) {
            return;
        }
        String args[] = string.split("_");
        if (args.length >= 10) {
            startTime      = Long.parseLong(args[1]);
            endTime        = Long.parseLong(args[2]);
            rotationValue  = Integer.parseInt(args[3]);
            originalWidth  = Integer.parseInt(args[4]);
            originalHeight = Integer.parseInt(args[5]);
            bitrate        = Integer.parseInt(args[6]);
            resultWidth    = Integer.parseInt(args[7]);
            resultHeight   = Integer.parseInt(args[8]);
            for (int a = 9; a < args.length; a++) {
                if (originalPath == null) {
                    originalPath = args[a];
                } else {
                    originalPath += "_" + args[a];
                }
            }
        }
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getRotationValue() {
        return rotationValue;
    }

    public void setRotationValue(int rotationValue) {
        this.rotationValue = rotationValue;
    }

    public int getOriginalWidth() {
        return originalWidth;
    }

    public void setOriginalWidth(int originalWidth) {
        this.originalWidth = originalWidth;
    }

    public int getOriginalHeight() {
        return originalHeight;
    }

    public void setOriginalHeight(int originalHeight) {
        this.originalHeight = originalHeight;
    }

    public int getResultWidth() {
        return resultWidth;
    }

    public void setResultWidth(int resultWidth) {
        this.resultWidth = resultWidth;
    }

    public int getResultHeight() {
        return resultHeight;
    }

    public void setResultHeight(int resultHeight) {
        this.resultHeight = resultHeight;
    }

    public int getBitrate() {
        return bitrate;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }
}
