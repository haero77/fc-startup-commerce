package com.fc.commerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class CommerceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        System.out.println("stse");
    }

}
