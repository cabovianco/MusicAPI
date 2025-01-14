package com.cabovianco.musicapi.util;

import com.cabovianco.musicapi.model.Song;
import com.cabovianco.musicapi.repository.entity.SongEntity;

public class SongEntityModelMapper {

    public static Song toModel(SongEntity entity) {
        Song model = new Song();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setArtistId(entity.getArtist().getId());
        model.setTimeInMinutes(entity.getTimeInMinutes());

        return model;
    }

    public static SongEntity toEntity(Song model) {
        SongEntity entity = new SongEntity();
        entity.setName(model.getName());
        entity.setTimeInMinutes(model.getTimeInMinutes());

        return entity;
    }

}
