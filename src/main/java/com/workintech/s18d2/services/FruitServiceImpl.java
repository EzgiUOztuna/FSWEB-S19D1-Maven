package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.validations.PlantValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository)
    {
        this.fruitRepository = fruitRepository;
    }


    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    public List<Fruit> getByPriceAsc()
    {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public Fruit getById(Long id) {
        PlantValidation.isValidId(id);
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if(fruitOptional.isPresent())
        {
            return fruitOptional.get();
        }
        throw new PlantException("This id is not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public Fruit save(Fruit fruit) {
        PlantValidation.dataControlFruit(fruit);
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> getAllFruitsByName(String name) {
        return fruitRepository.getAllFruitsByName(name);
    }

    @Override
    public Fruit delete(Long id) {
        PlantValidation.isValidId(id);
        Fruit fruit = getById(id);
        PlantValidation.dataControlFruit(fruit);
        fruitRepository.delete(fruit);
        return fruit;
    }
}