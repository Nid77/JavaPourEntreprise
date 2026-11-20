package org.formation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.formation.dto.CoffeeCreateDto;
import org.formation.dto.CoffeeDto;
import org.formation.service.CoffeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
 @RequestMapping("coffees")
public class CoffeeController {
    
    private final CoffeeService coffeeService;

    @PostMapping
    CoffeeDto create(@RequestBody @Valid CoffeeCreateDto coffeeCreateDto) {
        return  coffeeService.createCoffee(coffeeCreateDto);
    }

    @GetMapping("/")
    List<CoffeeDto> coffees(){
        return coffeeService.coffees();
    }

    @GetMapping("{id}")
    ResponseEntity<CoffeeDto> getCoffee(@PathVariable Long id){
        return coffeeService.getCoffee(id)
                .map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }
}
