package com.cabovianco.musicapi.service;

import com.cabovianco.musicapi.model.Song;

import java.util.List;

public interface MusicService {

    List<Song> getSongs();

    Song getSongById(Long id) throws Exception;

    void addSong(Song song);

    void updateSong(Long id, Song song) throws Exception;

    void deleteSongById(Long id) throws Exception;

    List<Song> getSongsByArtist(String artist);

}
