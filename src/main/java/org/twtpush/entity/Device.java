package org.twtpush.entity;

import java.util.Date;

/**
 * Created by nero on 16-8-18.
 */
public class Device {
    private long deviceId;

    private String deviceModel;

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", deviceModel='" + deviceModel + '\'' +
                ", deviceCreatetime=" + deviceCreatetime +
                '}';
    }

    private Date deviceCreatetime;

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public Date getDeviceCreatetime() {
        return deviceCreatetime;
    }

    public void setDeviceCreatetime(Date deviceCreatetime) {
        this.deviceCreatetime = deviceCreatetime;
    }
}
