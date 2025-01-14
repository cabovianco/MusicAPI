package com.cabovianco.musicapi.controller;

import com.cabovianco.musicapi.model.Artist;
import com.cabovianco.musicapi.service.ArtistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistService service;

    @Autowired
    public ArtistController(ArtistService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<Artist>> getArtists() {
        return ResponseEntity.ok(service.getArtists());
    }

    @GetMapping("/{id}")
    ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getArtistById(id));
    }

    @PostMapping
    ResponseEntity<Artist> addArtist(@Valid @RequestBody Artist artist) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addArtist(artist));
    }

    @PutMapping("/{id}")
    ResponseEntity<Artist> updateArtist(@PathVariable Long id, @Valid @RequestBody Artist artist) {
        return ResponseEntity.ok(service.updateArtist(id, artist));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Artist> deleteArtistById(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteArtistById(id));
    }

}
