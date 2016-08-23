package org.twtpush.dto.BrokerStatus;

/**
 * Created by nero on 16-8-22.
 */
public class Jvm_metrics {
    private Heap_memory heap_memory;

    private Non_heap_memory non_heap_memory;

    private Long classes_loaded;

    private Long classes_unloaded;

    private Long threads_current;

    private Long threads_peak;

    private String os_arch;

    private String os_name;

    private Long os_memory_total;

    private Long os_memory_free;

    private Long os_swap_total;

    private Long os_swap_free;

    private Long os_fd_open;

    private Long os_fd_max;

    private double os_load_average;

    private Long os_cpu_time;

    private Long os_processors;

    private String runtime_name;

    private String jvm_name;

    private Long uptime;

    private Long start_time;

    public Jvm_metrics() {
    }

    public Jvm_metrics(Heap_memory heap_memory, Non_heap_memory non_heap_memory, Long classes_loaded, Long classes_unloaded, Long threads_current, Long threads_peak, String os_arch, String os_name, Long os_memory_total, Long os_memory_free, Long os_swap_total, Long os_swap_free, Long os_fd_open, Long os_fd_max, double os_load_average, Long os_cpu_time, Long os_processors, String runtime_name, String jvm_name, Long uptime, Long start_time) {
        this.heap_memory = heap_memory;
        this.non_heap_memory = non_heap_memory;
        this.classes_loaded = classes_loaded;
        this.classes_unloaded = classes_unloaded;
        this.threads_current = threads_current;
        this.threads_peak = threads_peak;
        this.os_arch = os_arch;
        this.os_name = os_name;
        this.os_memory_total = os_memory_total;
        this.os_memory_free = os_memory_free;
        this.os_swap_total = os_swap_total;
        this.os_swap_free = os_swap_free;
        this.os_fd_open = os_fd_open;
        this.os_fd_max = os_fd_max;
        this.os_load_average = os_load_average;
        this.os_cpu_time = os_cpu_time;
        this.os_processors = os_processors;
        this.runtime_name = runtime_name;
        this.jvm_name = jvm_name;
        this.uptime = uptime;
        this.start_time = start_time;
    }

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
    public void setClasses_loaded(Long classes_loaded){
        this.classes_loaded = classes_loaded;
    }
    public Long getClasses_loaded(){
        return this.classes_loaded;
    }
    public void setClasses_unloaded(Long classes_unloaded){
        this.classes_unloaded = classes_unloaded;
    }
    public Long getClasses_unloaded(){
        return this.classes_unloaded;
    }
    public void setThreads_current(Long threads_current){
        this.threads_current = threads_current;
    }
    public Long getThreads_current(){
        return this.threads_current;
    }
    public void setThreads_peak(Long threads_peak){
        this.threads_peak = threads_peak;
    }
    public Long getThreads_peak(){
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
    public void setOs_memory_total(Long os_memory_total){
        this.os_memory_total = os_memory_total;
    }
    public Long getOs_memory_total(){
        return this.os_memory_total;
    }
    public void setOs_memory_free(Long os_memory_free){
        this.os_memory_free = os_memory_free;
    }
    public Long getOs_memory_free(){
        return this.os_memory_free;
    }
    public void setOs_swap_total(Long os_swap_total){
        this.os_swap_total = os_swap_total;
    }
    public Long getOs_swap_total(){
        return this.os_swap_total;
    }
    public void setOs_swap_free(Long os_swap_free){
        this.os_swap_free = os_swap_free;
    }
    public Long getOs_swap_free(){
        return this.os_swap_free;
    }
    public void setOs_fd_open(Long os_fd_open){
        this.os_fd_open = os_fd_open;
    }
    public Long getOs_fd_open(){
        return this.os_fd_open;
    }
    public void setOs_fd_max(Long os_fd_max){
        this.os_fd_max = os_fd_max;
    }
    public Long getOs_fd_max(){
        return this.os_fd_max;
    }
    public void setOs_load_average(double os_load_average){
        this.os_load_average = os_load_average;
    }
    public double getOs_load_average(){
        return this.os_load_average;
    }
    public void setOs_cpu_time(Long os_cpu_time){
        this.os_cpu_time = os_cpu_time;
    }
    public Long getOs_cpu_time(){
        return this.os_cpu_time;
    }
    public void setOs_processors(Long os_processors){
        this.os_processors = os_processors;
    }
    public Long getOs_processors(){
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
    public void setUptime(Long uptime){
        this.uptime = uptime;
    }
    public Long getUptime(){
        return this.uptime;
    }
    public void setStart_time(Long start_time){
        this.start_time = start_time;
    }
    public Long getStart_time(){
        return this.start_time;
    }

    @Override
    public String toString() {
        return "Jvm_metrics{" +
                "heap_memory=" + heap_memory +
                ", non_heap_memory=" + non_heap_memory +
                ", classes_loaded=" + classes_loaded +
                ", classes_unloaded=" + classes_unloaded +
                ", threads_current=" + threads_current +
                ", threads_peak=" + threads_peak +
                ", os_arch='" + os_arch + '\'' +
                ", os_name='" + os_name + '\'' +
                ", os_memory_total=" + os_memory_total +
                ", os_memory_free=" + os_memory_free +
                ", os_swap_total=" + os_swap_total +
                ", os_swap_free=" + os_swap_free +
                ", os_fd_open=" + os_fd_open +
                ", os_fd_max=" + os_fd_max +
                ", os_load_average=" + os_load_average +
                ", os_cpu_time=" + os_cpu_time +
                ", os_processors=" + os_processors +
                ", runtime_name='" + runtime_name + '\'' +
                ", jvm_name='" + jvm_name + '\'' +
                ", uptime=" + uptime +
                ", start_time=" + start_time +
                '}';
    }
}
