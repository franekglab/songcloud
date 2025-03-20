package com.songcloud.domain.crud.song;

import com.songcloud.domain.crud.dto.ArtistDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArtistRetriever {

    private final ArtistRepository artistRepository;

    Set<ArtistDto> findAllArtists() {
        return artistRepository.findAll()
                .stream()
                .map(artist -> new ArtistDto(
                        artist.getId(),
                        artist.getName()))
                .collect(Collectors.toSet());
    }
}
