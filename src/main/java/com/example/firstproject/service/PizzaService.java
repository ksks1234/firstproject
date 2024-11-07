package com.example.firstproject.service;

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
}
