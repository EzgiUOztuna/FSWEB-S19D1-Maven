package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vegetable", schema = "fsweb")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "is_grownontree")
    private Boolean isGrownOnTree;

    public void setGrownOnTree(Boolean isGrownOnTree)
    {
        this.isGrownOnTree = isGrownOnTree;
    }

    public Boolean isGrownOnTree()
    {
        return isGrownOnTree;
    }
}