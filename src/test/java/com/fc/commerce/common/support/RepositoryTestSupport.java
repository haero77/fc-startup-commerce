package com.fc.commerce.common.support;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

@ActiveProfiles(value = "test")
@DataJpaTest
public abstract class RepositoryTestSupport {

	@Container
	private static final MySQLContainer mySQLContainer = new MySQLContainer("mysql:latest");

	@DynamicPropertySource
	private static void configureProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
		registry.add("spring.datasource.username", mySQLContainer::getUsername);
		registry.add("spring.datasource.password", mySQLContainer::getPassword);
	}

	@BeforeAll
	static void beforeAll() {
		mySQLContainer.start();
	}

	@AfterAll
	static void afterAll() {
		mySQLContainer.stop();
	}

}
