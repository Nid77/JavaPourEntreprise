package org.formation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class Coffee {
    @Id
    @GeneratedValue
    Long id;
    @NotBlank(message = "Coffee name cannot be null")
    private String name;
    @PositiveOrZero(message = "Price should be positive or zeeo")
    private int price;

    public Coffee(String name, int price) {
        this.name = name;
        this.price = price;
    }
}


