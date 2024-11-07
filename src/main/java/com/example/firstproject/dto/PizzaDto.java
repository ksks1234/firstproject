package com.example.firstproject.dto;

import com.example.firstproject.enetity.Member;
import com.example.firstproject.enetity.Pizza;
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

    public Pizza toEntity() {
        return new Pizza(id, name, price);
    }
}
