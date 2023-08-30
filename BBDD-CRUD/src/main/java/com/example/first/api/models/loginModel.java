package com.example.first.api.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class loginModel {

    @Id
    @Column(name="UserEmail")
    private String userEmail;

    @Column(name = "UserName")
    @Value("Fulanito")
    private String userName;

    @NonNull
    @Column(name="UserPassword")
    private String userPassword;

    @Column(name="UserType")
    @Value("Normal")
    private String userType;

    @Column(name="UserFavorites", columnDefinition = "TEXT")
    @Value("no tengo, soy asi de rancio")
    private String userFavs;


}

