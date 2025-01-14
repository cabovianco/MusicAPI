package com.cabovianco.musicapi.util;

import com.cabovianco.musicapi.model.Artist;
import com.cabovianco.musicapi.repository.entity.ArtistEntity;

public class ArtistEntityModelMapper {

    public static Artist toModel(ArtistEntity entity) {
        Artist model = new Artist();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setSongs(
                entity.getSongs()
                        .stream()
                        .map(SongEntityModelMapper::toModel)
                        .toList()
        );

        return model;
    }

    public static ArtistEntity toEntity(Artist model) {
        ArtistEntity entity = new ArtistEntity();
        entity.setName(model.getName());

        return entity;
    }

}
