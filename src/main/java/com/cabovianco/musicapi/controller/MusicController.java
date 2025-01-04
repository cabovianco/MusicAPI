package com.cabovianco.musicapi.controller;

import com.cabovianco.musicapi.model.Song;
import com.cabovianco.musicapi.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusicController {

    private final MusicService service;

    @Autowired
    public MusicController(MusicService service) {
        this.service = service;
    }

    @GetMapping("/songs")
    List<Song> getSongs() {
        return service.getSongs();
    }

    @GetMapping("/songs/{id}")
    Song getSongById(@PathVariable Long id) {
        try {
            return service.getSongById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/songs")
    void addSong(@RequestBody Song song) {
        service.addSong(song);
    }

    @PutMapping("/songs/{id}")
    void updateSong(@PathVariable Long id, @RequestBody Song song) {
        try {
            service.updateSong(id, song);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/songs/{id}")
    void deleteSong(@PathVariable Long id) {
        try {
            service.deleteSongById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/songs/filter")
    List<Song> getSongsByArtist(@RequestParam String artist) {
        return service.getSongsByArtist(artist);
    }

}
