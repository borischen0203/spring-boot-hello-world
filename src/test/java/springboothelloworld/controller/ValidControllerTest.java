package springboothelloworld.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springboothelloworld.service.ValidNumberService;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValidControllerTest {

    @InjectMocks
    private ValidController undertest;
    @Mock
    private ValidNumberService validNumberService;

    @Test
    void checkNumber() {
        when(validNumberService.isValid(any())).thenReturn(true);
        assertTrue(undertest.checkNumber("1332535"));
    }
}
