package com.jullierme.test.business.device.mapper;

import com.jullierme.test.business.device.dto.DeviceRequest;
import com.jullierme.test.business.device.dto.DeviceResponse;
import com.jullierme.test.domain.Device;

public interface DeviceMapper {
    Device toDevice(DeviceRequest request);
    DeviceResponse toResponse(Device device);
}
