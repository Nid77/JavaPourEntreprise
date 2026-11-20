package org.formation.repository;

import org.formation.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
