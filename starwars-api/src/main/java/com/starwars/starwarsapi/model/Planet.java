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
public class Planet extends ResourceHolderSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer rotationPeriod;
    private Integer orbitalPeriod;
    private Integer diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private Integer surfaceWater;
    private Long population;
}
