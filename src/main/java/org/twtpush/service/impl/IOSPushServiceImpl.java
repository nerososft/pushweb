package org.twtpush.service.impl;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import org.springframework.stereotype.Service;
import org.twtpush.dto.Operate;
import org.twtpush.service.IIOSPushService;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-5
 * time: 上午11:31.
 */
@Service
public class IOSPushServiceImpl implements IIOSPushService {
    public Operate push() {
        ApnsService service =
                APNS.newService()
                        .withCert("/path/to/certificate.p12", "MyCertPassword")
                        .withSandboxDestination()
                        .build();

        String payload = APNS.newPayload().alertBody("Can't be simpler than this!").build();

        String token = "fedfbcfb....";
        service.push(token, payload);

        return null;
    }
}
