package com.songcloud.domain.crud.song;


import com.songcloud.domain.crud.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class AlbumRetriever {

    private final AlbumRepository albumRepository;

    AlbumDtoWithArtistsAndSongs findAlbumByIdWithArtistsAndSongs(final Long id) {
        Album album = albumRepository.findAlbumByIdWithSongsAndArtists(id)
                .orElseThrow(() -> new AlbumNotFoundException("Album with id " + id + " not found"));

        Set<Artist> artists = album.getArtists();
        Set<Song> songs = album.getSongs();

        AlbumDto albumDto = new AlbumDto(album.getId(), album.getName());

        Set<ArtistDto> artistsDto = artists.stream()
                .map(artist -> new ArtistDto(
                        artist.getId(),
                        artist.getName()
                )).collect(Collectors.toSet());

        Set<SongDto> songsDto = songs.stream()
                .map(song -> new SongDto(
                        song.getId(),
                        song.getName()
                )).collect(Collectors.toSet());

        return new AlbumDtoWithArtistsAndSongs(albumDto, artistsDto, songsDto);
    }
}
