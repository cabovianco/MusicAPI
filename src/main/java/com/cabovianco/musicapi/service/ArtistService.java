package com.cabovianco.musicapi.service;

import com.cabovianco.musicapi.model.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> getArtists();

    Artist getArtistById(Long id);

    Artist addArtist(Artist artist);

    Artist updateArtist(Long id, Artist artist);

    Artist deleteArtistById(Long id);

}
