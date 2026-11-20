package org.formation.service;

import org.formation.dto.CoffeeCreateDto;
import org.formation.dto.CoffeeDto;

import java.util.List;
import java.util.Optional;

public interface CoffeeService {

    List<CoffeeDto> coffees();
    Optional<CoffeeDto> getCoffee(Long id);

    CoffeeDto createCoffee(CoffeeCreateDto dto);
}
