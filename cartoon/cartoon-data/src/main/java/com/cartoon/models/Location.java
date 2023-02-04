package com.cartoon.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Location implements IHaveSourceId {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int sourceId;
    private String name;
    private String type;
    private String dimension;
    @OneToMany
    private List<Character> residents = new ArrayList<>();
}
