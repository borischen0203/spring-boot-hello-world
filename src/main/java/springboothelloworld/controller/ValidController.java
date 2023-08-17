package springboothelloworld.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springboothelloworld.service.ValidNumberService;

@RestController
public class ValidController {

//    @Autowired
//    private ValidNumberService validNumberService;

    @GetMapping("/api/card/{number}")
    public boolean checkNumber(@PathVariable String number) {
        return ValidNumberService.isValid(number);
    }
}
