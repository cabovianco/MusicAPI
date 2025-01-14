package com.cabovianco.musicapi.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

import java.util.List;

@Data
public class Artist {

    @Null
    private Long id;

    @NotNull(message = "Name cant be null")
    private String name;

    @Null
    private List<Song> songs;

}
