package com.cabovianco.musicapi.controller;

import com.cabovianco.musicapi.model.Song;
import com.cabovianco.musicapi.service.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService service;

    @Autowired
    public SongController(SongService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<Song>> getSongs() {
        return ResponseEntity.ok(service.getSongs());
    }

    @GetMapping("/{id}")
    ResponseEntity<Song> getSongById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSongById(id));
    }

    @PostMapping
    ResponseEntity<Song> addSong(@Valid @RequestBody Song song) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addSong(song));
    }

    @PutMapping("/{id}")
    ResponseEntity<Song> updateSong(@PathVariable Long id, @Valid @RequestBody Song song) {
        return ResponseEntity.ok(service.updateSong(id, song));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Song> deleteSong(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteSongById(id));
    }

}
