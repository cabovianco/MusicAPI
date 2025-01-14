package com.cabovianco.musicapi.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Song {

    @Null
    private Long id;

    @NotNull(message = "Name cant be null")
    private String name;

    @NotNull
    private Long artistId;

    @NotNull(message = "Time cant be null")
    @Min(value = 0, message = "Time cant be less than zero")
    private Double timeInMinutes;

}
