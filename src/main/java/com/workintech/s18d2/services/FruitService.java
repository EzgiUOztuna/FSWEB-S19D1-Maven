
package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {
    List<Fruit> getByPriceAsc();
    List<Fruit> getByPriceDesc();
    Fruit getById(Long id);
    Fruit save(Fruit fruit);
    Fruit delete(Long id);
    List<Fruit> searchByName(String name);

    //List<Fruit> getAllFruitsByName(String name);

}
