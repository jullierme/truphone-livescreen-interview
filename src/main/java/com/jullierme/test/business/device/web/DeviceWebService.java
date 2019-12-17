package com.jullierme.test.business.device.web;

import com.jullierme.test.business.device.dto.DeviceRequest;
import com.jullierme.test.business.device.dto.DeviceResponse;
import com.jullierme.test.domain.Device;

public interface DeviceWebService {
    DeviceResponse create(DeviceRequest device);
}
