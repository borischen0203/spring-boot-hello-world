package springboothelloworld.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

class ValidNumberServiceTest {

    private ValidNumberService undertest;

    @BeforeEach
    void setUp() {
        undertest = new ValidNumberService();
    }

    @Test
    void isValid() {
        boolean result = undertest.isValid("4012888888881881");
        assertTrue(result);
    }
}
