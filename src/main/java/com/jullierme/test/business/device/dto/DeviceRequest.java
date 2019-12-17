package com.jullierme.test.business.device.dto;

import lombok.Value;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Value
public class DeviceRequest {
    @NotEmpty
    private String imei;

    @NotEmpty
    private String name;
}
