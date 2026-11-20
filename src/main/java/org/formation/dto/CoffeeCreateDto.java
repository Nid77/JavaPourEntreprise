package org.formation.dto;

import jakarta.validation.constraints.NotBlank;

public record CoffeeCreateDto(
        @NotBlank(message = "Coffee name cannot be null")
        String name,
        @NotBlank(message = "Price should be positive")
        int price) {
}
