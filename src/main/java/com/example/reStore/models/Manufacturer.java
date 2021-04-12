package com.example.reStore.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Manufacturer {
    @Id
    private Integer manufacturer_id;

    private String name;
    private String country;

    @OneToMany(targetEntity = Model.class)
    private List models;
}
