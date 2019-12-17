package com.jullierme.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jullierme.test.config")
class TestApplicationTests {

	@Test
	void contextLoads() {
	}

}
