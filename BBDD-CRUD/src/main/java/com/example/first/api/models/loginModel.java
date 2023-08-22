package com.example.first.api.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class loginModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="UserEmail", unique = true)
    private String userEmail;

    @Column(name = "UserName")
    private String userName;

    @NonNull
    @Column(name="UserPassword")
    private String userPassword;

    @Column(name="UserType")
    private String userType;

    @Column(name="UserFavorites")
    private String userFavs;

}
