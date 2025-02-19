package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.FruitResponseRecord;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/fruit")
public class FruitController {

    private FruitService fruitService;

    @GetMapping
    public List<Fruit> getByPriceAsc(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Fruit> orderByCostHighToLow(){
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public FruitResponseRecord findById(@PathVariable Long id) {
        Fruit fruit = fruitService.getById(id);
        return new FruitResponseRecord("get by id succeed", fruitService.getById(id));
    }

    @GetMapping("/name/{name}")
    public List<Fruit> searchByName(@PathVariable String name){
        return fruitService.searchByName(name);
    }

    @PostMapping
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }



    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable Long id){
            return fruitService.delete(id);
    }
}