package com.workintech.s18d2.controller;

import com.workintech.s18d2.services.VegetableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/vegetables")
public class VegetableController {
    private VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService)
    {
        this.vegetableService = vegetableService;
    }
}