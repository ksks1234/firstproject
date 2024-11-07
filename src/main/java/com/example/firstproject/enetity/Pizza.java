package com.example.firstproject.enetity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;

    public void patch(Pizza pizza) {
        if(pizza.name != null)
            this.name = pizza.name;
        if(pizza.price != null)
            this.price = pizza.price;
    }
}
