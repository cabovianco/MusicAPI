package com.cabovianco.musicapi.util;

import com.cabovianco.musicapi.model.Song;
import com.cabovianco.musicapi.repository.entity.SongEntity;

public class EntityModelMapper {

    public static Song entityToModel(SongEntity entity) {
        Song model = new Song();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setArtist(entity.getArtist());
        model.setTimeInMinutes(entity.getTimeInMinutes());

        return model;
    }

    public static SongEntity modelToEntity(Song model) {
        SongEntity entity = new SongEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setArtist(model.getArtist());
        entity.setTimeInMinutes(model.getTimeInMinutes());

        return entity;
    }

}
