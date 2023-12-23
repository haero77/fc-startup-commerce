package com.fc.commerce.common.support;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.junit.jupiter.Container;

@ActiveProfiles(value = "test")
@DataJpaTest
public abstract class RepositoryTestSupport {

    /**
     * new MariaDBContainer("mariadb"); // "mariadb" 를 작성해야 mariadb:latest 로 적용된다.
     * "mariadb"를 명시하지 않을 경우 default 버전이 10.3.6 arm64 에서 실행이 매우 느림.
     */
    @Container
    private static final MariaDBContainer mariaDBContainer = new MariaDBContainer("mariadb");

    @DynamicPropertySource
    private static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mariaDBContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mariaDBContainer::getUsername);
        registry.add("spring.datasource.password", mariaDBContainer::getPassword);
    }

    @BeforeAll
    static void beforeAll() {
        mariaDBContainer.start();
    }

    @AfterAll
    static void afterAll() {
        mariaDBContainer.stop();
    }

}
