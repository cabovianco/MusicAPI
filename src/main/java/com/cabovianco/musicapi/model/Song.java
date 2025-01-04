package com.cabovianco.musicapi.model;

import lombok.Data;

@Data
public class Song {

    private Long id;
    private String name;
    private String artist;
    private Double timeInMinutes;

}
