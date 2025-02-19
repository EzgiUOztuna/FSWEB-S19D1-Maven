package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.FruitResponseRecord;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/fruit")
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService)
    {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getByPriceAsc()
    {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public FruitResponseRecord findById(@PathVariable Long id)
    {
        Fruit fruit = fruitService.getById(id);
        return new FruitResponseRecord(fruit.getName(), fruit.getPrice());
    }

    @GetMapping("/desc")
    public List<Fruit> orderByCostHighToLow()
    {
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit save(@RequestBody Fruit fruit)
    {
        return fruitService.save(fruit);
    }

    @GetMapping("/name/{name}")
    public List<Fruit> searchByName(@PathVariable String name)
    {
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable Long id)
    {
        Fruit fruit = fruitService.getById(id);
        if(fruit != null)
        {
            fruitService.delete(id);
        }
        return fruit;
    }
}