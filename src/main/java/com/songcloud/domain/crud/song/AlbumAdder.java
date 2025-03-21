package com.songcloud.domain.crud.song;

import com.songcloud.domain.crud.dto.AlbumDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@AllArgsConstructor
@Service
class AlbumAdder {

    private final SongRetriever songRetriever;
    private final AlbumRepository albumRepository;

    AlbumDto addAlbum(final Long songId, final String name, final Instant releaseDate) {
        Song song = songRetriever.findSongById(songId);
        Album album = new Album();
        album.setName(name);
        album.addSongToAlbum(song);
        album.setReleaseDate(releaseDate);
        Album savedAlbum = albumRepository.save(album);
        return new AlbumDto(savedAlbum.getId(), savedAlbum.getName());
    }
}
