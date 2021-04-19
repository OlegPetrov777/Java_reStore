package com.example.reStore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String set_number; // артикул
    private String name;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="manufacturer_id")
    private Manufacturer manufacturer;

    @OneToMany (mappedBy="model", fetch=FetchType.EAGER)
    private Collection<Product> products;

}
