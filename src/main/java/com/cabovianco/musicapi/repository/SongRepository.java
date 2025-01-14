package com.cabovianco.musicapi.repository;

import com.cabovianco.musicapi.repository.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Long> {

    @Query(value = "SELECT * FROM songs ORDER BY id", nativeQuery = true)
    List<SongEntity> findAllSongs();

}
