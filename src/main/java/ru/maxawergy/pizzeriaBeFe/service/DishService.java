package ru.maxawergy.pizzeriaBeFe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maxawergy.pizzeriaBeFe.entity.Dish;
import ru.maxawergy.pizzeriaBeFe.repository.DishJPA;

import java.util.List;

@Service
public class DishService {
    @Autowired
    private DishJPA dishJPA;

    public List<Dish> getAllDishes(){
        return dishJPA.findAll();
    }

    public void saveDish(Dish dish){
        dishJPA.save(dish);
    }
}
