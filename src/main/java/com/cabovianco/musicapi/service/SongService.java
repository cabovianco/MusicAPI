package com.cabovianco.musicapi.service;

import com.cabovianco.musicapi.model.Song;

import java.util.List;

public interface SongService {

    List<Song> getSongs();

    Song getSongById(Long id);

    Song addSong(Song song);

    Song updateSong(Long id, Song song);

    Song deleteSongById(Long id);

}
