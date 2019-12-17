package com.jullierme.test;

import com.jullierme.test.business.device.DeviceService;
import com.jullierme.test.business.device.DeviceServiceImpl;
import com.jullierme.test.business.device.exception.DuplicatedDeviceException;
import com.jullierme.test.domain.Device;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.jullierme.test.config.DataProviderConfig.DEVICES_COLLECTION;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DeviceServiceTest {

    private Set<Device> devices;

    private DeviceService deviceService;

    @BeforeEach
    void setUp() {
        devices = Collections.synchronizedSet(new HashSet<>());
        deviceService = new DeviceServiceImpl(devices);
    }

    @Nested
    @DisplayName("when create device")
    class CreateDevice {
        @Test
        void shouldCreateNewDevice() {
            //given
            String imei = "imei";
            String name = "name";
            Device device = dummyDevice(imei, name);

            //when
            Device savedDevice = deviceService.create(device);

            //then
            assertNotNull(savedDevice);
            assertEquals(imei, savedDevice.getImei());
            assertEquals(name, savedDevice.getName());
            assertNotNull(savedDevice.getCreated());
        }

        @Test
        void whenSave_shouldNotAcceptInvalidParameter() {
            //given
            Device device = null;

            //when
            Executable executable = () -> deviceService.create(device);

            //then
            assertThrows(IllegalArgumentException.class, executable);
        }

        @Test
        void shouldNotAcceptDuplicateDevices() {
            //given
            String imei = "imei";
            String name = "name";
            Device device = dummyDevice(imei, name);
            deviceService.create(device);

            //when
            Executable executable = () -> deviceService.create(device);

            //then
            assertThrows(DuplicatedDeviceException.class, executable);
        }

        @Test
        void whenCreate_shouldNotAcceptDeviceWithNullValues(){
            //given
            Device device = Device.builder().build();

            //when
            Executable executable = () -> deviceService.create(device);

            //then
            assertThrows(IllegalArgumentException.class, executable);
        }
    }

    @Nested
    @DisplayName("when read device")
    class ReadDevice {

        @Test
        void givenIMEI_whenFind_shouldReturnADevice(){
            //given
            String imei = "teste";

            //when
            Device device = deviceService.find(imei).orElse(null);

            //then
            assertNotNull(device);
            assertEquals(imei, device.getImei());
        }
    }


    @Test
    private Device dummyDevice(String imei, String name) {
        return Device.builder().imei(imei).name(name).build();
    }
}
