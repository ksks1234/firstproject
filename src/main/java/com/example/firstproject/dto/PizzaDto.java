package com.example.firstproject.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
public class PizzaDto {
    private Long id;
    private String name;
    private String price;
}
