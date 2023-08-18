package com.example.first.api.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@Entity
@Table(name="goods")
public class models {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name="Name")
    private String prodName;
    @Column(name="Type")
    private enumType prodType ;
    @Value("Tu frase aqui")
    @Column(name="Message")
    private String prodMessage;
    @Nullable
    @Value("")
    @Column(name="Size")
    private enumSize prodSize;      //Dani: Revisar si da problemas el null con la enumeracion
    @Value("White")
    @Column(name="Color")
    private String prodColor;

    public models(){

    }
    public models(int id, String prodName, enumType prodType, String prodMessage, enumSize prodSize, String prodColor){
        this.id=id;
        this.prodName=prodName;
        this.prodType=prodType;
        this.prodMessage=prodMessage;
        this.prodSize=prodSize;
        this.prodColor=prodColor;
    }

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
