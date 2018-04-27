package com.starwars.starwarsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.support.ResourceHolderSupport;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class People extends ResourceHolderSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String birthYear;
    private String eyeColor;
    private String gender;
    private String height;
    private String mass;
    private String skinColor;
    private String hairColor;
}