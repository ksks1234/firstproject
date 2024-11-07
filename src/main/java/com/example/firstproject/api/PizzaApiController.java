package com.example.firstproject.api;

import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.enetity.Pizza;
import com.example.firstproject.service.PizzaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    // 2. 단건 조회
    @GetMapping("/api/pizzas/{id}")
    public Pizza show(@PathVariable Long id) {
        return pizzaService.show(id);
    }
    // 3. 삽입
    @PostMapping("/api/pizzas")
    public ResponseEntity<Pizza> create(@RequestBody PizzaDto dto) {
        Pizza created = pizzaService.create(dto);
        return (created != null)?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    // 4. 수정
    @PatchMapping("/api/pizzas/{id}")
    public ResponseEntity<Pizza> update(@PathVariable Long id,
                                        @RequestBody PizzaDto dto){
        Pizza updated = pizzaService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    // 5. 삭제

}
