package com.starwars.starwarsbatch.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@XmlRootElement(name = "people")
public class people {
    @Id
    @GeneratedValue
    private String peopleId;
    private String name;
    private String birthYear;
    private String gender;
    private String height;
    private String mass;
    private String eyeColor;
    private String hairColor;
    private String skinColor;

}
