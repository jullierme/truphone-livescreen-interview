package com.jullierme.test.business.device.web;

import com.jullierme.test.business.device.DeviceService;
import com.jullierme.test.business.device.dto.DeviceRequest;
import com.jullierme.test.business.device.dto.DeviceResponse;
import com.jullierme.test.business.device.mapper.DeviceMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class DeviceWebServiceImpl implements DeviceWebService {
    private final DeviceService deviceService;
    private final DeviceMapper deviceMapper;

    @Override
    public DeviceResponse create(DeviceRequest request) {
        log.debug("create(device{})", request);

        return deviceMapper.toResponse(deviceService.create(deviceMapper.toDevice(request)));
    }
}
