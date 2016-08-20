package org.twtpush.dao;

import org.apache.ibatis.annotations.Param;
import org.twtpush.entity.Device;

import java.util.List;

/**
 * Created by nero on 16-8-18.
 */
public interface DeviceDao {
    /**
     * query devices info from offset to offset+limit
     * @param offset
     * @param limit
     * @return
     */
    List<Device> queryAll(@Param("offset") int offset,@Param("limit") int limit);

    /**
     * delete device by id
     * @param deviceId
     * @return
     */
    int deleteById(long deviceId);
}
