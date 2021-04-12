package com.example.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Role {
    @Id
    private Integer role_id;
    private String name;
    @OneToMany(targetEntity = User.class)
    private List users;
}
