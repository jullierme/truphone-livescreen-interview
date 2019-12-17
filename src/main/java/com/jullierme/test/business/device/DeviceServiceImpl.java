package com.jullierme.test.business.device;

import com.jullierme.test.business.device.exception.DuplicatedDeviceException;
import com.jullierme.test.domain.Device;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import static com.jullierme.test.config.DataProviderConfig.DEVICES_COLLECTION;

@Service
@AllArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    @Qualifier(DEVICES_COLLECTION)
    private final Set<Device> devices;

    @Override
    public Device create(@NonNull Device device) {
        validateDeviceProperties(device);
        validateDuplicatedDevice(device);

        device.setCreated(LocalDate.now());

        devices.add(device);

        return device;
    }

    private void validateDeviceProperties(@NonNull Device device) {
        if (device.getImei() == null || device.getName() == null)
            throw new IllegalArgumentException();
    }

    private void validateDuplicatedDevice(@NonNull Device device) {
        if (devices.contains(device))
            throw new DuplicatedDeviceException();
    }

    @Override
    public Optional<Device> find(String imei) {
        return Optional.of(
                Device.builder()
                        .imei(imei)
                        .name("device' name")
                        .created(LocalDate.now())
                        .build()
        );

    }
}
