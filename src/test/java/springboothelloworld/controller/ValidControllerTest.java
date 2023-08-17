package springboothelloworld.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springboothelloworld.service.ValidNumberService;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidControllerTest {

    private ValidController undertest;

    @BeforeEach
    void setUp() {
        undertest = new ValidController();
    }

    @Test
    void checkNumber() {
        assertTrue(undertest.checkNumber("1332535"));
    }
}
