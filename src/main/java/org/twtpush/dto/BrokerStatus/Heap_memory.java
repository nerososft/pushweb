package org.twtpush.dto.BrokerStatus;

/**
 * Created by nero on 16-8-22.
 */
public class Heap_memory {
    private Long used;

    private Long alloc;

    private Long max;

    public Heap_memory() {
    }

    public Heap_memory(Long used, Long alloc, Long max) {
        this.used = used;
        this.alloc = alloc;
        this.max = max;
    }

    public void setUsed(Long used){
        this.used = used;
    }
    public Long getUsed(){
        return this.used;
    }
    public void setAlloc(Long alloc){
        this.alloc = alloc;
    }
    public Long getAlloc(){
        return this.alloc;
    }
    public void setMax(Long max){
        this.max = max;
    }
    public Long getMax(){
        return this.max;
    }

    @Override
    public String toString() {
        return "Heap_memory{" +
                "used=" + used +
                ", alloc=" + alloc +
                ", max=" + max +
                '}';
    }
}
