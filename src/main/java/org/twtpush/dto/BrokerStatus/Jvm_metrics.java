package org.twtpush.dto.BrokerStatus;

/**
 * Created by nero on 16-8-22.
 */
public class Jvm_metrics {
    private Heap_memory heap_memory;

    private Non_heap_memory non_heap_memory;

    private int classes_loaded;

    private int classes_unloaded;

    private int threads_current;

    private int threads_peak;

    private String os_arch;

    private String os_name;

    private int os_memory_total;

    private int os_memory_free;

    private int os_swap_total;

    private int os_swap_free;

    private int os_fd_open;

    private int os_fd_max;

    private double os_load_average;

    private int os_cpu_time;

    private int os_processors;

    private String runtime_name;

    private String jvm_name;

    private int uptime;

    private int start_time;

    public void setHeap_memory(Heap_memory heap_memory){
        this.heap_memory = heap_memory;
    }
    public Heap_memory getHeap_memory(){
        return this.heap_memory;
    }
    public void setNon_heap_memory(Non_heap_memory non_heap_memory){
        this.non_heap_memory = non_heap_memory;
    }
    public Non_heap_memory getNon_heap_memory(){
        return this.non_heap_memory;
    }
    public void setClasses_loaded(int classes_loaded){
        this.classes_loaded = classes_loaded;
    }
    public int getClasses_loaded(){
        return this.classes_loaded;
    }
    public void setClasses_unloaded(int classes_unloaded){
        this.classes_unloaded = classes_unloaded;
    }
    public int getClasses_unloaded(){
        return this.classes_unloaded;
    }
    public void setThreads_current(int threads_current){
        this.threads_current = threads_current;
    }
    public int getThreads_current(){
        return this.threads_current;
    }
    public void setThreads_peak(int threads_peak){
        this.threads_peak = threads_peak;
    }
    public int getThreads_peak(){
        return this.threads_peak;
    }
    public void setOs_arch(String os_arch){
        this.os_arch = os_arch;
    }
    public String getOs_arch(){
        return this.os_arch;
    }
    public void setOs_name(String os_name){
        this.os_name = os_name;
    }
    public String getOs_name(){
        return this.os_name;
    }
    public void setOs_memory_total(int os_memory_total){
        this.os_memory_total = os_memory_total;
    }
    public int getOs_memory_total(){
        return this.os_memory_total;
    }
    public void setOs_memory_free(int os_memory_free){
        this.os_memory_free = os_memory_free;
    }
    public int getOs_memory_free(){
        return this.os_memory_free;
    }
    public void setOs_swap_total(int os_swap_total){
        this.os_swap_total = os_swap_total;
    }
    public int getOs_swap_total(){
        return this.os_swap_total;
    }
    public void setOs_swap_free(int os_swap_free){
        this.os_swap_free = os_swap_free;
    }
    public int getOs_swap_free(){
        return this.os_swap_free;
    }
    public void setOs_fd_open(int os_fd_open){
        this.os_fd_open = os_fd_open;
    }
    public int getOs_fd_open(){
        return this.os_fd_open;
    }
    public void setOs_fd_max(int os_fd_max){
        this.os_fd_max = os_fd_max;
    }
    public int getOs_fd_max(){
        return this.os_fd_max;
    }
    public void setOs_load_average(double os_load_average){
        this.os_load_average = os_load_average;
    }
    public double getOs_load_average(){
        return this.os_load_average;
    }
    public void setOs_cpu_time(int os_cpu_time){
        this.os_cpu_time = os_cpu_time;
    }
    public int getOs_cpu_time(){
        return this.os_cpu_time;
    }
    public void setOs_processors(int os_processors){
        this.os_processors = os_processors;
    }
    public int getOs_processors(){
        return this.os_processors;
    }
    public void setRuntime_name(String runtime_name){
        this.runtime_name = runtime_name;
    }
    public String getRuntime_name(){
        return this.runtime_name;
    }
    public void setJvm_name(String jvm_name){
        this.jvm_name = jvm_name;
    }
    public String getJvm_name(){
        return this.jvm_name;
    }
    public void setUptime(int uptime){
        this.uptime = uptime;
    }
    public int getUptime(){
        return this.uptime;
    }
    public void setStart_time(int start_time){
        this.start_time = start_time;
    }
    public int getStart_time(){
        return this.start_time;
    }
}
