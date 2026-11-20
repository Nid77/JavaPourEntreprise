package org.formation.service;

import jakarta.annotation.PostConstruct;
import org.formation.dto.CoffeeCreateDto;
import org.formation.dto.CoffeeDto;
import org.formation.entity.Coffee;
import org.formation.mapper.CoffeeMapper;
import org.formation.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    public CoffeeServiceImpl(CoffeeRepository repository) {
        this.repository = repository;
    }

    CoffeeRepository repository;
    private CoffeeMapper coffeeMapper;

    @Override
    public List<CoffeeDto> coffees() {
        return repository.findAll().stream().map(coffeeMapper::toDto).toList();
    }

    @Override
    public Optional<CoffeeDto> getCoffee(Long id) {
        return repository.findById(id).map(coffeeMapper::toDto);
    }

    @Override
    public CoffeeDto createCoffee(CoffeeCreateDto coffeeDto) {
        Coffee c = coffeeMapper.toEntity(coffeeDto);
        Coffee saved = repository.save(c);
        return coffeeMapper.toDto(saved);
    }


    @PostConstruct
    public void initDb() {
        repository.saveAll(List.of(new Coffee("Bob", 12)));
    }

}
