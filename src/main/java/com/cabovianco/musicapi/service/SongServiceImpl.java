package com.cabovianco.musicapi.service;

import com.cabovianco.musicapi.exception.ArtistNotFoundException;
import com.cabovianco.musicapi.exception.SongNotFoundException;
import com.cabovianco.musicapi.model.Song;
import com.cabovianco.musicapi.repository.ArtistRepository;
import com.cabovianco.musicapi.repository.SongRepository;
import com.cabovianco.musicapi.repository.entity.ArtistEntity;
import com.cabovianco.musicapi.repository.entity.SongEntity;
import com.cabovianco.musicapi.util.SongEntityModelMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cabovianco.musicapi.util.SongEntityModelMapper.toEntity;
import static com.cabovianco.musicapi.util.SongEntityModelMapper.toModel;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    @Autowired
    public SongServiceImpl(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Song> getSongs() {
        return songRepository.findAllSongs()
                .stream()
                .map(SongEntityModelMapper::toModel)
                .toList();
    }

    @Override
    @SneakyThrows
    public Song getSongById(Long id) {
        SongEntity entity = songRepository.findById(id)
                .orElseThrow(SongNotFoundException::new);

        return toModel(entity);
    }

    @Override
    @SneakyThrows
    public Song addSong(Song song) {
        ArtistEntity artistEntity = artistRepository.findById(song.getArtistId())
                .orElseThrow(ArtistNotFoundException::new);

        SongEntity songEntity = toEntity(song);
        songEntity.setArtist(artistEntity);

        return toModel(songRepository.save(songEntity));
    }

    @Override
    @SneakyThrows
    public Song updateSong(Long id, Song song) {
        SongEntity entity = songRepository.findById(id)
                .orElseThrow(SongNotFoundException::new);

        SongEntity updatedEntity = toEntity(song);
        entity.setName(updatedEntity.getName());

        ArtistEntity artistEntity = artistRepository.findById(song.getArtistId())
                .orElseThrow(ArtistNotFoundException::new);

        entity.setArtist(artistEntity);
        entity.setTimeInMinutes(updatedEntity.getTimeInMinutes());

        return toModel(songRepository.save(entity));
    }

    @Override
    @SneakyThrows
    public Song deleteSongById(Long id) {
        SongEntity entity = songRepository.findById(id)
                .orElseThrow(SongNotFoundException::new);

        songRepository.delete(entity);
        return toModel(entity);
    }

}
