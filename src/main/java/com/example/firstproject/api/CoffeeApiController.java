package com.example.firstproject.api;

import com.example.firstproject.enetity.Coffee;
import com.example.firstproject.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CoffeeApiController {
    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/api/coffees")
    public List<Coffee> index() {
        return coffeeService.index();
    }
}
