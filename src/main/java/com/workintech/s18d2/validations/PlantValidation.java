package com.workintech.s18d2.validations;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.http.HttpStatus;

public class PlantValidation {
    public static void isValidId(Long id)
    {
        if(id == null || id <= 0)
        {
            throw new PlantException("id is not null or equal zero or lower zero", HttpStatus.BAD_REQUEST);
        }
    }

    public static void dataControlFruit(Fruit fruit)
    {
        if(fruit == null)
        {
            throw new PlantException("Fruit is not null", HttpStatus.BAD_REQUEST);
        }
    }

    public static void dataControlVegetable(Vegetable vegetable)
    {
        if(vegetable == null)
        {
            throw new PlantException("Vegetable is not null", HttpStatus.BAD_REQUEST);
        }
    }


}