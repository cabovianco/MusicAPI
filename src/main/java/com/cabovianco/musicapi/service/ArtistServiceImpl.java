package com.cabovianco.musicapi.service;

import com.cabovianco.musicapi.exception.ArtistNotFoundException;
import com.cabovianco.musicapi.model.Artist;
import com.cabovianco.musicapi.repository.ArtistRepository;
import com.cabovianco.musicapi.repository.entity.ArtistEntity;
import com.cabovianco.musicapi.util.ArtistEntityModelMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cabovianco.musicapi.util.ArtistEntityModelMapper.toEntity;
import static com.cabovianco.musicapi.util.ArtistEntityModelMapper.toModel;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository repository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Artist> getArtists() {
        return repository.findAllArtists()
                .stream()
                .map(ArtistEntityModelMapper::toModel)
                .toList();
    }

    @Override
    @SneakyThrows
    public Artist getArtistById(Long id) {
        ArtistEntity artist = repository.findById(id)
                .orElseThrow(ArtistNotFoundException::new);

        return toModel(artist);
    }

    @Override
    public Artist addArtist(Artist artist) {
        return toModel(repository.save(toEntity(artist)));
    }

    @Override
    @SneakyThrows
    public Artist updateArtist(Long id, Artist artist) {
        ArtistEntity entity = repository.findById(id)
                .orElseThrow(ArtistNotFoundException::new);

        ArtistEntity updatedEntity = toEntity(artist);
        entity.setName(updatedEntity.getName());

        return toModel(repository.save(entity));
    }

    @Override
    @SneakyThrows
    public Artist deleteArtistById(Long id) {
        ArtistEntity artist = repository.findById(id)
                .orElseThrow(ArtistNotFoundException::new);

        repository.deleteById(id);
        return toModel(artist);
    }

}
