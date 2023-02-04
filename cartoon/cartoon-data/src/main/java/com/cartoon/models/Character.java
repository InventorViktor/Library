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
public class Character implements IHaveSourceId {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int sourceId;
    private String name;
    private String status;
    private String species;
    private String gender;

    @OneToOne
    private Location origin;
    @OneToOne
    private Location location;
    private String image;
    @ManyToMany(cascade = CascadeType.PERSIST,
                fetch = FetchType.EAGER)
    @JoinTable(
            name = "characters_episodes",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "episode_id")
    )
    private Set<Episode> episodes = new HashSet<>();

    public void addAllEpisodes(List<Episode> episodes) {
        this.episodes.addAll(episodes);
        episodes.forEach(episode -> episode.getCharacters().add(this));
    }
}
