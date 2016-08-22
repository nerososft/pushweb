package org.twtpush.dto.BrokerStatus;

import org.twtpush.dto.Broker.Connection;

import java.util.List;

/**
 * {
 "id": "default",
 "state": "STARTING",
 "state_since": 1471856089398,
 "version": "1.7.1",
 "home_location": "/opt/apache-apollo-1.7.1",
 "base_location": "/opt/apache-apollo-1.7.1/bin/twt",
 "jvm_metrics": {
 "heap_memory": {
 "used": 75596152,
 "alloc": 218103808,
 "max": 954728448
 },
 "non_heap_memory": {
 "used": 40754176,
 "alloc": 41353216,
 "max": 136314880
 },
 "classes_loaded": 6900,
 "classes_unloaded": 0,
 "threads_current": 36,
 "threads_peak": 41,
 "os_arch": "amd64",
 "os_name": "Linux 4.4.0-34-generic (Ubuntu 16.04.1 LTS)",
 "os_memory_total": 8279302144,
 "os_memory_free": 310333440,
 "os_swap_total": 0,
 "os_swap_free": 15999168512,
 "os_fd_open": 147,
 "os_fd_max": 100000,
 "os_load_average": 0.21,
 "os_cpu_time": 11150000000,
 "os_processors": 8,
 "runtime_name": "11942@nero-Lenovo-Y430P",
 "jvm_name": "Java HotSpot(TM) 64-Bit Server VM 1.7.0_80 (Oracle Corporation)",
 "uptime": 162504,
 "start_time": 1471856086106
 },
 "current_time": 1471856252952,
 "virtual_hosts": [
 "twt"
 ],
 "connectors": [
 "tcp",
 "tls",
 "ws",
 "wss"
 ],
 "connection_counter": 0,
 "connected": 0,
 "connections": [],
 "messages_sent": 0,
 "messages_received": 0,
 "read_counter": 0,
 "write_counter": 0
 }
 * Created by nero on 16-8-22.
 */
public class BrokerStatus {
    private String id;

    private String state;

    private int state_since;

    private String version;

    private String home_location;

    private String base_location;

    private Jvm_metrics jvm_metrics;

    private int current_time;

    private List<String> virtual_hosts ;

    private List<String> connectors ;

    private int connection_counter;

    private int connected;

    private List<Connection> connections ;

    private int messages_sent;

    private int messages_received;

    private int read_counter;

    private int write_counter;

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }
    public void setState_since(int state_since){
        this.state_since = state_since;
    }
    public int getState_since(){
        return this.state_since;
    }
    public void setVersion(String version){
        this.version = version;
    }
    public String getVersion(){
        return this.version;
    }
    public void setHome_location(String home_location){
        this.home_location = home_location;
    }
    public String getHome_location(){
        return this.home_location;
    }
    public void setBase_location(String base_location){
        this.base_location = base_location;
    }
    public String getBase_location(){
        return this.base_location;
    }
    public void setJvm_metrics(Jvm_metrics jvm_metrics){
        this.jvm_metrics = jvm_metrics;
    }
    public Jvm_metrics getJvm_metrics(){
        return this.jvm_metrics;
    }
    public void setCurrent_time(int current_time){
        this.current_time = current_time;
    }
    public int getCurrent_time(){
        return this.current_time;
    }
    public void setVirtualhosts(List<String> virtual_hosts){
        this.virtual_hosts = virtual_hosts;
    }
    public List<String> getVirtual_hosts(){
        return this.virtual_hosts;
    }
    public void setString(List<String> connectors){
        this.connectors = connectors;
    }
    public List<String> getString(){
        return this.connectors;
    }
    public void setConnection_counter(int connection_counter){
        this.connection_counter = connection_counter;
    }
    public int getConnection_counter(){
        return this.connection_counter;
    }
    public void setConnected(int connected){
        this.connected = connected;
    }
    public int getConnected(){
        return this.connected;
    }
    public void setConnections(List<Connection> connections){
        this.connections = connections;
    }
    public List<Connection> getConnections(){
        return this.connections;
    }
    public void setMessages_sent(int messages_sent){
        this.messages_sent = messages_sent;
    }
    public int getMessages_sent(){
        return this.messages_sent;
    }
    public void setMessages_received(int messages_received){
        this.messages_received = messages_received;
    }
    public int getMessages_received(){
        return this.messages_received;
    }
    public void setRead_counter(int read_counter){
        this.read_counter = read_counter;
    }
    public int getRead_counter(){
        return this.read_counter;
    }
    public void setWrite_counter(int write_counter){
        this.write_counter = write_counter;
    }
    public int getWrite_counter(){
        return this.write_counter;
    }
}
