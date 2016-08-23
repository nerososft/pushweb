package org.twtpush.dto.BrokerStatus;

/**
 * Created by nero on 16-8-22.
 */
public class Non_heap_memory {

    private int used;

    private int alloc;

    private int max;

    public Non_heap_memory() {
    }

    public Non_heap_memory(int used, int alloc, int max) {
        this.used = used;
        this.alloc = alloc;
        this.max = max;
    }

    public void setUsed(int used){
        this.used = used;
    }
    public int getUsed(){
        return this.used;
    }
    public void setAlloc(int alloc){
        this.alloc = alloc;
    }
    public int getAlloc(){
        return this.alloc;
    }
    public void setMax(int max){
        this.max = max;
    }
    public int getMax(){
        return this.max;
    }

    @Override
    public String toString() {
        return "Non_heap_memory{" +
                "used=" + used +
                ", alloc=" + alloc +
                ", max=" + max +
                '}';
    }
}
