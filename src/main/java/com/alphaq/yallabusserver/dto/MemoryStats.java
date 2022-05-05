package com.alphaq.yallabusserver.dto;

public class MemoryStats {
    private long heapSize;
    private long heapMaxSize;
    private long heapFreeMemory;

    public void setHeapSize(long heapSize) {
        this.heapSize = heapSize;
    }

    public void setHeapMaxSize(long maxMemory) {
        this.heapMaxSize = maxMemory;

    }

    public void setHeapFreeSize(long freeMemory) {
        this.heapFreeMemory = freeMemory;
    }

    public long getHeapSize() {
        return heapSize;
    }

    public long getHeapMaxSize() {
        return heapMaxSize;
    }

    public long getHeapFreeMemory() {
        return heapFreeMemory;
    }
}
