package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.validations.PlantValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{

    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository)
    {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> orderByCostHighToLow() {
        return vegetableRepository.orderByCostHighToLow();
    }

    @Override
    public List<Vegetable> findByName(String name) {
        return vegetableRepository.findByName(name);
    }

    @Override
    public List<Vegetable> orderByCostLowToHigh() {
        return vegetableRepository.orderByCostLowToHigh();
    }

    @Override
    public Vegetable findById(Long id) {
        PlantValidation.isValidId(id);
        Optional<Vegetable> optionalVegetable = vegetableRepository.findById(id);
        if(optionalVegetable.isPresent())
        {
            return  optionalVegetable.get();
        }
        return null;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        PlantValidation.dataControlVegetable(vegetable);
        return vegetableRepository.save(vegetable);
    }

    @Override
    public List<Vegetable> getAllVegetablesByName(String name) {
        return vegetableRepository.getAllVegetablesByName(name);
    }

    @Override
    public void deleteById(Long id) {
        PlantValidation.isValidId(id);
        Vegetable vegetable = findById(id);
        PlantValidation.dataControlVegetable(vegetable);
        vegetableRepository.deleteById(id);
    }


}