package com.xuc.wex.common.idcreater;

public class IdWorker2 {

    private final long workerId;
    private final static long twepoch = 1431705600000L;
    private long sequence = 0L;
    private final static long workerIdBits = 4L;                                    //机器标识位数
    public final static long maxWorkerId = -1L ^ -1L << workerIdBits;               //机器ID最大值
    private final static long sequenceBits = 10L;                                   //毫秒内自增位
    private final static long workerIdShift = sequenceBits;                         //机器ID偏左移
    private final static long timestampLeftShift = sequenceBits + workerIdBits;     //时间毫秒左移
    public final static long sequenceMask = -1L ^ -1L << sequenceBits;
    private long lastTimestamp = -1L;

    public IdWorker2(final long workerId) {
        super();
        if (workerId > this.maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format(
                    "worker Id can't be greater than %d or less than 0",
                    this.maxWorkerId));
        }
        this.workerId = workerId;
    }

    public synchronized long nextId() {
        long timestamp = this.timeGen();
        if (this.lastTimestamp == timestamp) {
            this.sequence = (this.sequence + 1) & this.sequenceMask;
            if (this.sequence == 0) {
                System.out.println("###########" + sequenceMask);
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }

        } else {
            this.sequence = 0;
        }
        if (timestamp < this.lastTimestamp) {
            try {
                throw new Exception(
                        String.format(
                                "Clock moved backwards.  Refusing to generate id for %d milliseconds",
                                this.lastTimestamp - timestamp));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        this.lastTimestamp = timestamp;
        long nextId = ((timestamp - twepoch << timestampLeftShift)) | (this.workerId << this.workerIdShift) | (this.sequence);
//  System.out.println("timestamp:" + timestamp + ",timestampLeftShift:"
//    + timestampLeftShift + ",nextId:" + nextId + ",workerId:"
//    + workerId + ",sequence:" + sequence);
        return nextId;
    }

    private long tilNextMillis(final long lastTimestamp) {

        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;

    }

    private long timeGen() {

        return System.currentTimeMillis();
    }

}
