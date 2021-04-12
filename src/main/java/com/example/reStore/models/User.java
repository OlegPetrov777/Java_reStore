package com.example.reStore.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private Boolean is_active; // подтвердил ли почту

//    @OneToOne(targetEntity = UserProfile.class)
//    private UserProfile user_profile;
//    @ManyToOne
//    private Role role_id;


}
