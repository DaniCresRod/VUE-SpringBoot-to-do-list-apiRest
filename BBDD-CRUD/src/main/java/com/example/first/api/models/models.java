package com.example.first.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class models {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String prodName;
    private enumType prodType ;
    private String prodMessage;
    private enumSize prodSize;
    private String prodColor;


    enum enumType{
        SHIRT,
        HOODIE,
        MUG,
        BOTTLE
    }

    enum enumSize{
        S,M,L,XL
    }


}
