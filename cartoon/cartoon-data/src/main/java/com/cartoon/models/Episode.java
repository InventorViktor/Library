package com.cartoon.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Episode implements IHaveSourceId {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int sourceId;
    private String name;
    private String air_date;
    @ManyToMany(mappedBy = "episodes",
                fetch = FetchType.EAGER)
    private Set<Character> characters = new HashSet<>();
}
