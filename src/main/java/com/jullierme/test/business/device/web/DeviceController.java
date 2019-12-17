package com.jullierme.test.business.device.web;

import com.jullierme.test.business.device.dto.DeviceRequest;
import com.jullierme.test.business.device.dto.DeviceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/device")
@AllArgsConstructor
public class DeviceController {
    private DeviceWebService deviceWebService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceResponse create(@RequestBody @Valid DeviceRequest request) {
        return deviceWebService.create(request);
    }

    @PutMapping("/{imei}")
    public DeviceResponse update(@PathVariable String imei,
                                 @RequestBody @Valid DeviceRequest request) {
        return deviceWebService.update(request);
    }

    @GetMapping("/{imei}")
    public ResponseEntity<DeviceResponse> find(@PathVariable String imei) {
        return deviceWebService.find(imei);

        return ResponseEntity.notFound().build();
    }

}
