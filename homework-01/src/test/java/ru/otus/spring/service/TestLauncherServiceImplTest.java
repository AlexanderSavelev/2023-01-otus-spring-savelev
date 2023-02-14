package ru.otus.spring.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

class TestLauncherServiceImplTest {

    static TestLauncherServiceImpl service;

    @BeforeAll
    static void beforeAll() {
        service = new TestLauncherServiceImpl();
    }

    @org.junit.jupiter.api.Test
    void setTestName() {
        String testName = "test";
        service.setTestName(testName);
        Assertions.assertEquals(testName, service.getTestName());
    }
}