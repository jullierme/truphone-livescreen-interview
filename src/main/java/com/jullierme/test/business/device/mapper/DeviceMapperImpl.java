package com.jullierme.test.business.device.mapper;

import com.jullierme.test.business.device.dto.DeviceRequest;
import com.jullierme.test.business.device.dto.DeviceResponse;
import com.jullierme.test.domain.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceMapperImpl implements DeviceMapper {
    @Override
    public Device toDevice(DeviceRequest request) {
        return Device.builder()
                .name(request.getName())
                .imei(request.getImei())
                .build();
    }

    @Override
    public DeviceResponse toResponse(Device device) {
        return DeviceResponse.builder()
                .created(device.getCreated())
                .imei(device.getImei())
                .name(device.getName())
                .build();
    }
}
