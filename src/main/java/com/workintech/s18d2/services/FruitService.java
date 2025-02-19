
package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> getByPriceDesc();
    List<Fruit> searchByName(String name);
    List<Fruit> getByPriceAsc();
    Fruit getById(Long id);
    Fruit save(Fruit fruit);
    List<Fruit> getAllFruitsByName(String name);
    Fruit delete(Long id);
}
