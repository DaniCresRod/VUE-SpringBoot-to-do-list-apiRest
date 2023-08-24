package com.example.first.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@Entity
@Table(name="goods")
@NoArgsConstructor
@AllArgsConstructor
public class models {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name="Type")
//    @Enumerated(EnumType.STRING)
    private String prodType ;
    @Value("Tu frase aqui")
    @Column(name="Message")
    private String prodMessage;
    //@Nullable
    @Value("")
    @Column(name="Size")
//    @Enumerated(EnumType.STRING)
    private String prodSize;      //Dani: Revisar si da problemas el null con la enumeracion
    @Value("White")
    @Column(name="Color")
    private String prodColor;


//    enum enumType{
//        Camiseta,
//        Sudadera,
//        Taza,
//        Botella
//    }
//
//    enum enumSize{
//        S,M,L,XL
//    }


}
