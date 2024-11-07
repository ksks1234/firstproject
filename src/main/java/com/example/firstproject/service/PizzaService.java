package com.example.firstproject.service;

import com.example.firstproject.dto.PizzaDto;
import com.example.firstproject.enetity.Pizza;
import com.example.firstproject.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    @Autowired
    PizzaRepository pizzaRepository;

    public List<Pizza> index() {
        return pizzaRepository.findAll();
    }

    public Pizza show(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }

    public Pizza create(PizzaDto dto) {
        Pizza pizza = dto.toEntity();
        if(pizza.getId() != null){
            return null;
        }
        return pizzaRepository.save(pizza);
    }

    public Pizza update(Long id, PizzaDto dto) {
        Pizza pizza = dto.toEntity();
        Pizza target = pizzaRepository.findById(id).orElse(null);
        if(target == null || id != pizza.getId()) {
            return null;
        }
        target.patch(pizza);
        Pizza updated = pizzaRepository.save(target);
        return updated;
    }

    public Pizza delete(Long id) {
        Pizza target = pizzaRepository.findById(id).orElse(null);
        if(target == null){
            return null;
        }
        pizzaRepository.delete(target);
        return target;
    }
}
