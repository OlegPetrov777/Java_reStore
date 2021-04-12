package com.example.reStore.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Product { //extends Model
    @Id
    private Integer product_id;

    private String color;
    private String size;
    private String description;
    private Integer price;
    private Integer pieces_in_stock; // количество в наличии

    @ManyToOne
    private Model model;

}
