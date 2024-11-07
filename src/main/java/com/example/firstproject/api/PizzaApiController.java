package com.example.firstproject.api;

import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.enetity.Pizza;
import com.example.firstproject.service.PizzaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PizzaApiController {
    @Autowired
    PizzaService pizzaService;
    
    // 1. 조회
    @GetMapping("/api/pizzas")
    public List<Pizza> index() {
        return pizzaService.index();
    }
    // 2. 생성
    // 3. 수정
    // 4. 삭제

}
