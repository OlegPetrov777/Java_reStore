package com.example.reStore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
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

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "student_id", nullable = false)
//    @JsonIgnore
//    private Student student;

//    @OneToMany(targetEntity = Product.class)
//    private List products;
//    @ManyToOne
//    private Manufacturer manufacturer;

}
