package com.example.first.api.models;

import jakarta.persistence.*;
import lombok.*;

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
    private String userName;

    @NonNull
    @Column(name="UserPassword")
    private String userPassword;

    @Column(name="UserType")
    private String userType;

    @Column(name="UserFavorites")
    private String userFavs;

}
