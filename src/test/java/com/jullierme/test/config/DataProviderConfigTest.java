package com.jullierme.test.config;

import com.jullierme.test.domain.Device;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static com.jullierme.test.config.DataProviderConfig.DEVICES_COLLECTION;

@SpringBootTest
class DataProviderConfigTest {

    @Autowired
    @Qualifier(DEVICES_COLLECTION)
    Set<Device> devices;

    @Test
    void shouldNotBeNull() {
        assertNotNull(devices);
    }
}
