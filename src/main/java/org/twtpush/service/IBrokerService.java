package org.twtpush.service;

import org.twtpush.dto.BrokerStatus.BrokerStatus;
import org.twtpush.dto.Result;

/**
 * Created by nero on 16-8-22.
 */
public interface IBrokerService {


    /**
     * get broker status
     * @return
     */

    Result<BrokerStatus> getBrokerStatus(String appKey,String appSecretKey);

}
