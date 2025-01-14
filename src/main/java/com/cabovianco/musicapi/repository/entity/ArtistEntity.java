package com.cabovianco.musicapi.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "artists")
public class ArtistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<SongEntity> songs = new ArrayList<>();

}
