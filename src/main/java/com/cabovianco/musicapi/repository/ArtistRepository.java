package com.cabovianco.musicapi.repository;

import com.cabovianco.musicapi.repository.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {

    @Query(value = "SELECT * FROM artists ORDER BY id", nativeQuery = true)
    List<ArtistEntity> findAllArtists();

}
