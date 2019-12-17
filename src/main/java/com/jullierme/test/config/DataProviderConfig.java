package com.jullierme.test.config;

import com.jullierme.test.domain.Device;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

@Configuration
public class DataProviderConfig {
    public static final String DEVICES_COLLECTION = "devicesCollection";

    @Scope(value = SCOPE_SINGLETON)
    @Bean(DEVICES_COLLECTION)
    public Set<Device> devicesCollection() {
        return Collections.synchronizedSet(new HashSet<>());
    }
}
