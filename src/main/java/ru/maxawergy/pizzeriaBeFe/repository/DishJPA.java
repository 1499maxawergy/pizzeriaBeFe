package ru.maxawergy.pizzeriaBeFe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxawergy.pizzeriaBeFe.entity.Dish;

import java.util.List;

@Repository
public interface DishJPA extends JpaRepository<Dish, Long> {
    public List<Dish> getAllBy();
    public Dish findDishByDishId(Long dishId);
}
