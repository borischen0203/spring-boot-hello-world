package springboothelloworld.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthControllerTest {

    private HealthController undertest;

    @BeforeEach
    void setUp() {
        undertest = new HealthController();
    }

    @Test
    void health() {
        assertEquals("ok", undertest.health());
    }
}
