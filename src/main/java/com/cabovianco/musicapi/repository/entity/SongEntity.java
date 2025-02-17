package com.cabovianco.musicapi.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "songs")
public class SongEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double timeInMinutes;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private ArtistEntity artist;

}
