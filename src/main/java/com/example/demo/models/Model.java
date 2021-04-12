package com.example.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer model_id;
    private String set_number; // артикул
    private String name;

    @OneToMany(targetEntity = Product.class)
    private List products;
    @ManyToOne
    private Manufacturer manufacturer;

}
