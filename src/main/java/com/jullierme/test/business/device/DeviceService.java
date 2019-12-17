package com.jullierme.test.business.device;

import com.jullierme.test.domain.Device;

import java.util.Optional;

public interface DeviceService {
    Device create(Device device);

    Optional<Device> find(String imei);
}
