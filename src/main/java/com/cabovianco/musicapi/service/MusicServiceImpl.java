package com.cabovianco.musicapi.service;

import com.cabovianco.musicapi.model.Song;
import com.cabovianco.musicapi.repository.MusicRepository;
import com.cabovianco.musicapi.repository.entity.SongEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.cabovianco.musicapi.util.EntityModelMapper.entityToModel;
import static com.cabovianco.musicapi.util.EntityModelMapper.modelToEntity;

@Service
public class MusicServiceImpl implements MusicService {

    private final MusicRepository repository;

    @Autowired
    public MusicServiceImpl(MusicRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Song> getSongs() {
        List<SongEntity> entities = repository.findAll();
        List<Song> models = new ArrayList<>();

        for (SongEntity e : entities)
            models.add(entityToModel(e));

        return models;
    }

    @Override
    public Song getSongById(Long id) throws Exception {
        SongEntity entity = repository.findById(id)
                .orElseThrow(() -> new Exception("Song not found."));

        return entityToModel(entity);
    }

    @Override
    public void addSong(Song song) {
        repository.save(modelToEntity(song));
    }

    @Override
    public void updateSong(Long id, Song song) throws Exception {
        SongEntity entity = repository.findById(id)
                .orElseThrow(() -> new Exception("Song not found."));

        SongEntity updatedEntity = modelToEntity(song);
        entity.setName(updatedEntity.getName());
        entity.setArtist(updatedEntity.getArtist());
        entity.setTimeInMinutes(updatedEntity.getTimeInMinutes());

        repository.save(entity);
    }

    @Override
    public void deleteSongById(Long id) throws Exception {
        SongEntity entity = repository.findById(id)
                .orElseThrow(() -> new Exception("Song not found"));

        repository.delete(entity);
    }

    @Override
    public List<Song> getSongsByArtist(String artist) {
        List<SongEntity> entities = repository.getSongsByArtist(artist);
        List<Song> models = new ArrayList<>();

        for (SongEntity e : entities)
            models.add(entityToModel(e));

        return models;
    }

}
