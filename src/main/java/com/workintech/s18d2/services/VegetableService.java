package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    List<Vegetable> orderByCostHighToLow();
    List<Vegetable> findByName(String name);
    List<Vegetable> orderByCostLowToHigh();
    Vegetable findById(Long id);
    Vegetable save(Vegetable vegetable);
    List<Vegetable> getAllVegetablesByName(String name);
    void deleteById(Long id);
}