package com.workintech.s18d2.dto;

import com.workintech.s18d2.entity.Fruit;

public record FruitResponseRecord(String message, Fruit fruit) {
}