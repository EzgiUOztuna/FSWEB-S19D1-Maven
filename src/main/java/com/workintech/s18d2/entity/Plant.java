/*package com.workintech.s18d2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@MappedSuperclass
public class Plant {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @NotNull(message= "name cannot be null")
    @Size(min=2, max=45, message="name size must be between 2 to 45.")
    private String name;

    @Column(name = "price")
    private double price;

}*/
