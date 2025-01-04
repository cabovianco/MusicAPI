package com.cabovianco.musicapi.repository;

import com.cabovianco.musicapi.repository.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<SongEntity, Long> {

    @Query(value = "SELECT * FROM songs WHERE artist = :artist", nativeQuery = true)
    List<SongEntity> getSongsByArtist(@Param("artist") String artist);

}
